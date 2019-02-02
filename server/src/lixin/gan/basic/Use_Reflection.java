package lixin.gan.basic;

import java.lang.reflect.InvocationTargetException;

public class Use_Reflection {
	public static void main(String[] args) {
		
		/**
		 * ƽʱ������ʹ��new�ؼ�������������֮ǰ��JVM�����ȼ������ֽ��룬 Ȼ�����new����new�Ķ����ģ������JVMָ��
		 * ������ķ�����Ի�ȡ���ģ�ӣ� ���������ֶ�ָ�������ģ�ӣ�������JVM�Լ��ȼ���
		 * ���ģ�ӣ���ΪClass
		 */
		
		/**
		 * ��ʽ1�� ͨ����������ȡ
		 */
		Person p = new Person();
		Class personClass = p.getClass();
		
		
		/**
		 * ��ʽ2�� ʹ������
		 */
		personClass = Person.class;
		
		
		/**
		 * ��ʽ3�� ʹ����İ��� + ����
		 */
		try {
			personClass = Class.forName("lixin.gan.basic.Person");
			
			// �޲ι���
			// Person p2 = (Person)personClass.getConstructor().newInstance();
			
			// �вι���
			Person p2 = (Person)personClass.getConstructor(int.class, String.class).newInstance(1, "abc");
			
			System.out.println(p2);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		
	}
}

class Person{
	private int id;
	private String name;
	public Person() {
		super();
	}
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
}
