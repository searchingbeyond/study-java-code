package lixin.gan;

import java.lang.Math.*;

public class Demo {
	public static void main(String[] args) {
		System.out.println("hello world");
	}
}

class User{
	private int id;
	private String name;
	private String pwd;
	
	public User(int id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (this == obj) {
			return true;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		User tmp = (User) obj;
		if (tmp.id != this.id) {
			return false;
		}
		
		return true;
	}
}