package lixin.gan;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Use_ObjectInputStream_ObjectOutputStream {
	
	/**
	 * ObjectInputStream 和 ObjectOutputStream 使用来对象序列化与反序列化的
	 * 与DataInputStream和DataOutputStream一样，写出的顺序要和读入的顺序一样
	 * 不是所有对象都可以序列化，需要实现Serializable接口
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 序列化
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(byteArrayOutputStream));
		objectOutputStream.writeUTF("hello");
		objectOutputStream.writeObject(new Date());
		objectOutputStream.writeObject(new Student(1, "abc", "male"));
		objectOutputStream.writeObject(new Student(2, "xyz", "female"));
		objectOutputStream.flush();
		byte[] data = byteArrayOutputStream.toByteArray();
		
		// 反序列化
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
		ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(byteArrayInputStream));
		String str = objectInputStream.readUTF();
		Object obj1 = objectInputStream.readObject();
		Object obj2 = objectInputStream.readObject();
		Object obj3 = objectInputStream.readObject();
		
		if (obj1 instanceof Date) {
			System.out.println((Date)obj1);
		}
		
		if (obj2 instanceof Student) {
			System.out.println((Student)obj2);
		}
		
		if (obj3 instanceof Student) {
			System.out.println((Student)obj3);
		}
	}
}

// 如果对象要序列化，必须实现Serializable接口
class Student implements Serializable{
	
	private int id;
	private transient double wage; // 加transient之后，在序列化的时候，该属性会被忽略
	private String name;
	private String gender;
	
	public Student() {
		super();
	}
	
	public Student(int id, String name, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
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
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}
}