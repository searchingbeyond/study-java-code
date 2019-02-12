package lixin.gan.note;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 利用反射，获取类的相关信息（类名、属性、方法、注解、构造器）
 * @author ganlixin
 */
public class Reflection02 {

	
	/**
	 * 获取类的名字
	 */
	public static void getClassName() {
		try {
			String path = "lixin.gan.orm.annotation.Person";
			Class clas = Class.forName(path);

			// 获得完整路径 + 类名
			System.out.println(clas.getName());  //  lixin.gan.orm.annotation.Person
			
			// 获得类名
			System.out.println(clas.getSimpleName());  // Person
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取属性信息
	 */
	public static void getFieldInfo() {
		try {
			String path = "lixin.gan.orm.annotation.Person";
			Class clas = Class.forName(path);

			/*
			 * 获取所有的public属性
			Field[] fields = clas.getFields();
			for (Field f : fields) {
				System.out.println(f);
			}
			*/
			
			/*
			 * 获取所有的属性（包括private）
			Field[] fields = clas.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field); // 默认打印属性的所有信息
				// private int lixin.gan.orm.annotation.Person.id
				
				System.out.println(field.getName());  // 只简单打印属性的名称
				// id
			}
			*/
			
			// 获取指定名称的属性
			Field field = clas.getDeclaredField("name");
			System.out.println(field + "--" + field.getName());
			// private java.lang.String lixin.gan.orm.annotation.Person.name--name
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 获取对象的方法
	 */
	public static void getMethodInfo() {
		try {
			String path = "lixin.gan.orm.annotation.Person";
			Class clas = Class.forName(path);

			/*
			 * 获取所有public的方法，注意，包含很多从父类中继承而来的public方法
			Method[] methods = clas.getMethods();
			for(Method method : methods) {
				System.out.println(method);
			}
			*/
			
			/*
			 * 获取所有public的方法
			 * 注意，只返回自己定义的方法，不会包含从父类中继承而来的public方法
			Method[] methods = clas.getDeclaredMethods();
			for(Method method : methods) {
				System.out.println(method);
			}
			*/
			
			// 获取指定的方法名称，需要指定方法的参数类型，因为可能会出现重载的多个同名方法
			Method method = clas.getDeclaredMethod("setName", String.class);
			System.out.println(method);
			// public void lixin.gan.orm.annotation.Person.setName(java.lang.String)
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 获取构造器的信息
	 */
	public static void getConstructorInfo() {
		try {
			String path = "lixin.gan.orm.annotation.Person";
			Class clas = Class.forName(path);
			
			// 获取所有public的构造器
			//Constructor[] constructors = clas.getConstructors();
			
			// 获取所有的构造器
			Constructor[] constructors = clas.getDeclaredConstructors();
			
			// 获取指定的构造器，需要传入参数，因为构造器可能会重载，不传入参数，表示无参构造器
			Constructor constructor = clas.getDeclaredConstructor(int.class, String.class, String.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public static void main(String[] args) {
		getConstructorInfo();

	}
}
