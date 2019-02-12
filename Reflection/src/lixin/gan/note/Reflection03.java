package lixin.gan.note;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import lixin.gan.orm.annotation.MyField;
import lixin.gan.orm.annotation.MyTable;
import lixin.gan.orm.annotation.Person;

/**
 * ͨ�����䣬��̬���ù����������������ԡ�ע��
 * @author ganlixin
 */
public class Reflection03 {
	
	/**
	 * ���÷�����ʵ��������
	 */
	public static void getInstance() {
		try {
			String path = "lixin.gan.orm.annotation.Person";
			
			/*ʹ�÷���
			Class<Person> clas =(Class<Person>)Class.forName(path);
			Person p = clas.newInstance(); // �����޲ι��췽��
			System.out.println(p);  // Person [id=0, name=null, gender=null]
			*/
			
			/* ʹ��ǿ������ת��
			Class clas = Class.forName(path);
			Person p = (Person)clas.newInstance();
			System.out.println(p);
			*/
			
			/*ͨ��ѡ������������ȡ����ʵ��*/
			Class clas = Class.forName(path);
			Constructor<Person> constructor = clas.getConstructor(int.class, String.class, String.class);
			Person p = constructor.newInstance(100, "ganlixin", "male");
			System.out.println(p);
			// Person [id=100, name=ganlixin, gender=male]
			
			// һ����ɿ���д��
			p = (Person) clas.getConstructor(int.class, String.class, String.class).newInstance(1001, "xyz", "male");
			System.out.println(p);
			// Person [id=1001, name=xyz, gender=male]
			// ע�������õ���getConstructor��Ҳ����ʹ��getDeclaredConstructor���Ͼ����ܹ����ã�Ӧ�þ���public��
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * ���÷�����������ͨ����
	 */
	public static void callSimpleMethod() {
		String path = "lixin.gan.orm.annotation.Person";
		try {
			Class clas = Class.forName(path);
			Constructor<Person> constructor = clas.getDeclaredConstructor(int.class, String.class, String.class);
			Person person = constructor.newInstance(100, "xyz", "male");
			System.out.println(person);
			
			// ��ȡҪ���õķ�����ע�⴫������б�����ͣ���Ϊ���ܳ�������
			Method method = clas.getDeclaredMethod("setName", String.class);
			// method.invode(obj, args);  ����obj�����method������������args
			method.invoke(person, "abc");
			System.out.println(person);
			// Person [id=100, name=abc, gender=male]
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ��������
	 */
	public static void manageField() {
		String path = "lixin.gan.orm.annotation.Person";
		try {
			Class clas = Class.forName(path);
			Constructor<Person> constructor = clas.getDeclaredConstructor(int.class, String.class, String.class);
			Person person = constructor.newInstance(100, "xyz", "male");
			System.out.println(person);
			
			// ֱ��ͨ��getter����setter�� ��ȡ����������ֵ
			person.getName();  
			
			Field field = clas.getDeclaredField("name");
			/*
			 * // ֱ�����û��߷�������ֵ�����û�з���Ȩ�ޣ��ͻ����
			 * field.get(person)
			 * field.set(person, "aaaa"); 
			 */
			
			// ��ȷ��ʽ��Ӧ��������Ϊ�ɻ�ȡ
			field.setAccessible(true);
			System.out.println(field.get(person));  // xyz
			field.set(person, "aaa");
			System.out.println(person);
			// Person [id=100, name=aaa, gender=male]
			
			/**
			 * field.get(obj) ��ʾ��ȡobj�����field����
			 * field.set(obj, value) ��ʾ����obj��field����ֵ
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡע��������Ϣ
	 */
	public static void getAnnotationsInfo() {
		String path = "lixin.gan.orm.annotation.Person";
		
		try {
			Class clas = Class.forName(path);
			Person p = (Person)clas.getConstructor(int.class, String.class, String.class).newInstance(100, "hello", "male");
			
			// ����������ע�⣬ע������ģ����������Ե�
			Annotation[] annotations = clas.getDeclaredAnnotations();
			for (Annotation a : annotations) {
				System.out.println(a);
			}
			/*
			@lixin.gan.orm.annotation.MyTable(value=Person)
			@lixin.gan.orm.annotation.MyAnnotation2(value=hehe)
			 */
			
			// ������ָ��ע��
			// �������Ѿ�֪����������Щע�⣬��������֪������һ��ע��������Ϣ��
			Annotation annotation = clas.getDeclaredAnnotation(MyTable.class);
			System.out.println(annotation);
			// @lixin.gan.orm.annotation.MyTable(value=person)
			System.out.println(((MyTable)annotation).value());  // person
			
			// Ҳ��������
			MyTable myTableAnnotation = (MyTable) clas.getDeclaredAnnotation(MyTable.class);
			System.out.println(myTableAnnotation);
			// @lixin.gan.orm.annotation.MyTable(value=person)
			System.out.println(myTableAnnotation.value());		// person
			
			
			// ������Ե�ע��, �ͻ�����ע����һ����
			// ע�⣬��Ҫ�Ȼ�����ԣ�Ȼ��ͨ����������ȡע��
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
