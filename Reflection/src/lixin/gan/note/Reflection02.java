package lixin.gan.note;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ���÷��䣬��ȡ��������Ϣ�����������ԡ�������ע�⡢��������
 * @author ganlixin
 */
public class Reflection02 {

	
	/**
	 * ��ȡ�������
	 */
	public static void getClassName() {
		try {
			String path = "lixin.gan.orm.annotation.Person";
			Class clas = Class.forName(path);

			// �������·�� + ����
			System.out.println(clas.getName());  //  lixin.gan.orm.annotation.Person
			
			// �������
			System.out.println(clas.getSimpleName());  // Person
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ������Ϣ
	 */
	public static void getFieldInfo() {
		try {
			String path = "lixin.gan.orm.annotation.Person";
			Class clas = Class.forName(path);

			/*
			 * ��ȡ���е�public����
			Field[] fields = clas.getFields();
			for (Field f : fields) {
				System.out.println(f);
			}
			*/
			
			/*
			 * ��ȡ���е����ԣ�����private��
			Field[] fields = clas.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field); // Ĭ�ϴ�ӡ���Ե�������Ϣ
				// private int lixin.gan.orm.annotation.Person.id
				
				System.out.println(field.getName());  // ֻ�򵥴�ӡ���Ե�����
				// id
			}
			*/
			
			// ��ȡָ�����Ƶ�����
			Field field = clas.getDeclaredField("name");
			System.out.println(field + "--" + field.getName());
			// private java.lang.String lixin.gan.orm.annotation.Person.name--name
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * ��ȡ����ķ���
	 */
	public static void getMethodInfo() {
		try {
			String path = "lixin.gan.orm.annotation.Person";
			Class clas = Class.forName(path);

			/*
			 * ��ȡ����public�ķ�����ע�⣬�����ܶ�Ӹ����м̳ж�����public����
			Method[] methods = clas.getMethods();
			for(Method method : methods) {
				System.out.println(method);
			}
			*/
			
			/*
			 * ��ȡ����public�ķ���
			 * ע�⣬ֻ�����Լ�����ķ�������������Ӹ����м̳ж�����public����
			Method[] methods = clas.getDeclaredMethods();
			for(Method method : methods) {
				System.out.println(method);
			}
			*/
			
			// ��ȡָ���ķ������ƣ���Ҫָ�������Ĳ������ͣ���Ϊ���ܻ�������صĶ��ͬ������
			Method method = clas.getDeclaredMethod("setName", String.class);
			System.out.println(method);
			// public void lixin.gan.orm.annotation.Person.setName(java.lang.String)
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * ��ȡ����������Ϣ
	 */
	public static void getConstructorInfo() {
		try {
			String path = "lixin.gan.orm.annotation.Person";
			Class clas = Class.forName(path);
			
			// ��ȡ����public�Ĺ�����
			//Constructor[] constructors = clas.getConstructors();
			
			// ��ȡ���еĹ�����
			Constructor[] constructors = clas.getDeclaredConstructors();
			
			// ��ȡָ���Ĺ���������Ҫ�����������Ϊ���������ܻ����أ��������������ʾ�޲ι�����
			Constructor constructor = clas.getDeclaredConstructor(int.class, String.class, String.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public static void main(String[] args) {
		getConstructorInfo();

	}
}
