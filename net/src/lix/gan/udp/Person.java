package lix.gan.udp;

import java.io.Serializable;

public class Person implements Serializable{
	private int id;
	private String name;
	private transient double wage; // 加transient后，在序列化时，该属性会被忽略
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
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int id, String name, double wage) {
		super();
		this.id = id;
		this.name = name;
		this.wage = wage;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
}
