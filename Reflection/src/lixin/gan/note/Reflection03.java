package lixin.gan.note;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import lixin.gan.orm.annotation.MyField;
import lixin.gan.orm.annotation.MyTable;
import lixin.gan.orm.annotation.Person;

/**
 * 通过反射，动态调用构造器、方法、属性、注解
 * @author ganlixin
 */
public class Reflection03 {
	
	/**
	 * 利用反射来实例化对象
	 */
	public static void getInstance() {
		try {
			String path = "lixin.gan.orm.annotation.Person";
			
			/*使用泛型
			Class<Person> clas =(Class<Person>)Class.forName(path);
			Person p = clas.newInstance(); // 调用无参构造方法
			System.out.println(p);  // Person [id=0, name=null, gender=null]
			*/
			
			/* 使用强制类型转换
			Class clas = Class.forName(path);
			Person p = (Person)clas.newInstance();
			System.out.println(p);
			*/
			
			/*通过选定构造器来获取对象实例*/
			Class clas = Class.forName(path);
			Constructor<Person> constructor = clas.getConstructor(int.class, String.class, String.class);
			Person p = constructor.newInstance(100, "ganlixin", "male");
			System.out.println(p);
			// Person [id=100, name=ganlixin, gender=male]
			
			// 一步完成可以写成
			p = (Person) clas.getConstructor(int.class, String.class, String.class).newInstance(1001, "xyz", "male");
			System.out.println(p);
			// Person [id=1001, name=xyz, gender=male]
			// 注意上面用得是getConstructor，也可以使用getDeclaredConstructor，毕竟，能够调用，应该就是public的
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 利用反射来调用普通方法
	 */
	public static void callSimpleMethod() {
		String path = "lixin.gan.orm.annotation.Person";
		try {
			Class clas = Class.forName(path);
			Constructor<Person> constructor = clas.getDeclaredConstructor(int.class, String.class, String.class);
			Person person = constructor.newInstance(100, "xyz", "male");
			System.out.println(person);
			
			// 获取要调用的方法，注意传入参数列表的类型，因为可能出现重载
			Method method = clas.getDeclaredMethod("setName", String.class);
			// method.invode(obj, args);  调用obj对象的method方法，参数是args
			method.invoke(person, "abc");
			System.out.println(person);
			// Person [id=100, name=abc, gender=male]
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 操作属性
	 */
	public static void manageField() {
		String path = "lixin.gan.orm.annotation.Person";
		try {
			Class clas = Class.forName(path);
			Constructor<Person> constructor = clas.getDeclaredConstructor(int.class, String.class, String.class);
			Person person = constructor.newInstance(100, "xyz", "male");
			System.out.println(person);
			
			// 直接通过getter或者setter来 获取、设置属性值
			person.getName();  
			
			Field field = clas.getDeclaredField("name");
			/*
			 * // 直接设置或者访问属性值，如果没有访问权限，就会出错
			 * field.get(person)
			 * field.set(person, "aaaa"); 
			 */
			
			// 正确方式，应该先设置为可获取
			field.setAccessible(true);
			System.out.println(field.get(person));  // xyz
			field.set(person, "aaa");
			System.out.println(person);
			// Person [id=100, name=aaa, gender=male]
			
			/**
			 * field.get(obj) 表示获取obj对象的field属性
			 * field.set(obj, value) 表示设置obj的field属性值
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取注解的相关信息
	 */
	public static void getAnnotationsInfo() {
		String path = "lixin.gan.orm.annotation.Person";
		
		try {
			Class clas = Class.forName(path);
			Person p = (Person)clas.getConstructor(int.class, String.class, String.class).newInstance(100, "hello", "male");
			
			// 获得类的所有注解，注意是类的，而不是属性的
			Annotation[] annotations = clas.getDeclaredAnnotations();
			for (Annotation a : annotations) {
				System.out.println(a);
			}
			/*
			@lixin.gan.orm.annotation.MyTable(value=Person)
			@lixin.gan.orm.annotation.MyAnnotation2(value=hehe)
			 */
			
			// 获得类的指定注解
			// 假设我已经知道该类有哪些注解，我现在想知道其中一个注解的相关信息，
			Annotation annotation = clas.getDeclaredAnnotation(MyTable.class);
			System.out.println(annotation);
			// @lixin.gan.orm.annotation.MyTable(value=person)
			System.out.println(((MyTable)annotation).value());  // person
			
			// 也可以这样
			MyTable myTableAnnotation = (MyTable) clas.getDeclaredAnnotation(MyTable.class);
			System.out.println(myTableAnnotation);
			// @lixin.gan.orm.annotation.MyTable(value=person)
			System.out.println(myTableAnnotation.value());		// person
			
			
			// 获得属性的注解, 和获得类的注解是一样的
			// 注意，需要先获得属性，然后通过属性来获取注解
			Field field = clas.getDeclaredField("name");
			MyField myFieldAnnotation = field.getDeclaredAnnotation(MyField.class);
			System.out.println(myFieldAnnotation);
			// @lixin.gan.orm.annotation.MyField(canEmpty=true, primaryKey=false, columnName=name, type=varchar, length=30)
			
			System.out.println(myFieldAnnotation.columnName() + "--" + myFieldAnnotation.type() + "--" + myFieldAnnotation.length());
			// name--varchar--30
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		getAnnotationsInfo();
	}
}
