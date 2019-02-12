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
	 * ObjectInputStream �� ObjectOutputStream ʹ�����������л��뷴���л���
	 * ��DataInputStream��DataOutputStreamһ����д����˳��Ҫ�Ͷ����˳��һ��
	 * �������ж��󶼿������л�����Ҫʵ��Serializable�ӿ�
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// ���л�
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(byteArrayOutputStream));
		objectOutputStream.writeUTF("hello");
		objectOutputStream.writeObject(new Date());
		objectOutputStream.writeObject(new Student(1, "abc", "male"));
		objectOutputStream.writeObject(new Student(2, "xyz", "female"));
		objectOutputStream.flush();
		byte[] data = byteArrayOutputStream.toByteArray();
		
		// �����л�
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

// �������Ҫ���л�������ʵ��Serializable�ӿ�
class Student implements Serializable{
	
	private int id;
	private transient double wage; // ��transient֮�������л���ʱ�򣬸����Իᱻ����
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