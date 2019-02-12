package lixin.gan.note;

import java.lang.reflect.Method;

/**
 * 测试效率
 * @author 甘立鑫
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
	 * 使用最原始的方式来调用方法
	 */
	public static void test1() {
		Person person = new Person("Jane");
		
		for (int i = 0; i < 100000000L; i++) {
			person.getName();
		}
	}
	
	/**
	 * 使用反射的方式来调用方法，并且每次都要进行权限检查（private、protected、public、default）
	 */
	public static void test2() {
		try {
			Class clas = Class.forName("lixin.gan.note.Person");
			
			Person person = (Person)clas.getConstructor(String.class).newInstance("Jane");
			
			Method method = clas.getDeclaredMethod("getName", null);
			// 通常，在调用一个方法的时候，我们会先检查权限问题，比如private的权限，不能在外部访问或调用。
			// 所以下面的1亿次的调用，就会进行1亿次权限检查
			
			for (int i = 0; i < 100000000L; i++) {
				method.invoke(person, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 同样使用反射的方式调用方法，只不过在调用之前，关闭权限检查，这样的话，不用每次调用方法都进行权限检查了
	 */
	public static void test3() {
		try {
			Class clas = Class.forName("lixin.gan.note.Person");
			
			Person person = (Person)clas.getConstructor(String.class).newInstance("Jane");
			
			Method method = clas.getDeclaredMethod("getName", null);
			
			method.setAccessible(true);
			// 通常，在调用一个方法的时候，我们会先检查权限问题，比如private的权限，不能在外部访问或调用。
			// 通过这一步设置后，之后调用这个方法，就不会进行权限检查了，即使他是private，也是可以调用的
			
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
		System.out.println("test1 耗费了 " + (end-start) + " 毫秒");
		
		start = System.currentTimeMillis();
		test2();
		end = System.currentTimeMillis();
		System.out.println("test2 耗费了 " + (end-start) + " 毫秒");
		
		start = System.currentTimeMillis();
		test3();
		end = System.currentTimeMillis();
		System.out.println("test3 耗费了 " + (end-start) + " 毫秒");
		
		/*
		统计数据如下：
		test1   147毫秒		148 毫秒		147 毫秒
		test2   1043 毫秒		938 毫秒		936 毫秒
		test3	477 毫秒		469 毫秒		470 毫秒
		 */
	}
}
