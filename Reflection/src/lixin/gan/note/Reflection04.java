package lixin.gan.note;

import java.lang.reflect.Method;

/**
 * ����Ч��
 * @author ������
 */
class Person {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}

public class Reflection04 {
	
	/**
	 * ʹ����ԭʼ�ķ�ʽ�����÷���
	 */
	public static void test1() {
		Person person = new Person("Jane");
		
		for (int i = 0; i < 100000000L; i++) {
			person.getName();
		}
	}
	
	/**
	 * ʹ�÷���ķ�ʽ�����÷���������ÿ�ζ�Ҫ����Ȩ�޼�飨private��protected��public��default��
	 */
	public static void test2() {
		try {
			Class clas = Class.forName("lixin.gan.note.Person");
			
			Person person = (Person)clas.getConstructor(String.class).newInstance("Jane");
			
			Method method = clas.getDeclaredMethod("getName", null);
			// ͨ�����ڵ���һ��������ʱ�����ǻ��ȼ��Ȩ�����⣬����private��Ȩ�ޣ��������ⲿ���ʻ���á�
			// ���������1�ڴεĵ��ã��ͻ����1�ڴ�Ȩ�޼��
			
			for (int i = 0; i < 100000000L; i++) {
				method.invoke(person, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ͬ��ʹ�÷���ķ�ʽ���÷�����ֻ�����ڵ���֮ǰ���ر�Ȩ�޼�飬�����Ļ�������ÿ�ε��÷���������Ȩ�޼����
	 */
	public static void test3() {
		try {
			Class clas = Class.forName("lixin.gan.note.Person");
			
			Person person = (Person)clas.getConstructor(String.class).newInstance("Jane");
			
			Method method = clas.getDeclaredMethod("getName", null);
			
			method.setAccessible(true);
			// ͨ�����ڵ���һ��������ʱ�����ǻ��ȼ��Ȩ�����⣬����private��Ȩ�ޣ��������ⲿ���ʻ���á�
			// ͨ����һ�����ú�֮���������������Ͳ������Ȩ�޼���ˣ���ʹ����private��Ҳ�ǿ��Ե��õ�
			
			for (int i = 0; i < 100000000L; i++) {
				method.invoke(person, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		long start, end;
		
		start = System.currentTimeMillis();
		test1();
		end = System.currentTimeMillis();
		System.out.println("test1 �ķ��� " + (end-start) + " ����");
		
		start = System.currentTimeMillis();
		test2();
		end = System.currentTimeMillis();
		System.out.println("test2 �ķ��� " + (end-start) + " ����");
		
		start = System.currentTimeMillis();
		test3();
		end = System.currentTimeMillis();
		System.out.println("test3 �ķ��� " + (end-start) + " ����");
		
		/*
		ͳ���������£�
		test1   147����		148 ����		147 ����
		test2   1043 ����		938 ����		936 ����
		test3	477 ����		469 ����		470 ����
		 */
	}
}
