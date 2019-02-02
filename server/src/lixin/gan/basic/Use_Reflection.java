package lixin.gan.basic;

import java.lang.reflect.InvocationTargetException;

public class Use_Reflection {
	public static void main(String[] args) {
		
		/**
		 * 平时我们在使用new关键字来创建对象之前，JVM会首先加载类字节码， 然后才能new对象，new的对象的模子是由JVM指定
		 * 利用类的反射可以获取类的模子， 可以我们手动指定对象的模子，而不是JVM自己先加载
		 * 类的模子，称为Class
		 */
		
		/**
		 * 方式1， 通过对象来获取
		 */
		Person p = new Person();
		Class personClass = p.getClass();
		
		
		/**
		 * 方式2， 使用类名
		 */
		personClass = Person.class;
		
		
		/**
		 * 方式3， 使用类的包名 + 类名
		 */
		try {
			personClass = Class.forName("lixin.gan.basic.Person");
			
			// 无参构造
			// Person p2 = (Person)personClass.getConstructor().newInstance();
			
			// 有参构造
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
