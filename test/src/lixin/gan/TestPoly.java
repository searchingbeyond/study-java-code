package lixin.gan;

public class TestPoly {
	public static void main(String[] args) {
		Animal a1 = new Animal();
		System.out.println(a1.name);  // animal
		a1.shout();	// 动物叫
		/*
		 * animal
		 * 动物叫
		 */
		
		Animal a2 = new Dog();
		System.out.println(a2.name);  // animal
		/*
		利用多态，通过父类引用，即使子类中有和父类同名的属性(值不同)，那么，在访问的时候，仍旧访问的是父类的属性
		要想访问的是子类的属性值，可以使用类型强制转换
		 */
		System.out.println(((Dog)a2).name); // Dog
		
		
		a2.shout();  // 狗叫
		a2.run();	// 动物run
		/*
		a2.sleep();
		利用多态，通过父类引用，只能调用父类中的方法，不能调用子类中新增的方法
		如果被重写了，执行就是子类中重写的方法，如果没有重写，就是父类中的方法。
		*/
	}
}

class Animal {
	public String name = "animal";
	
	public void shout() {
		System.out.println("动物叫");
	}
	
	public void run() {
		System.out.println("动物run");
	}
}

class Dog extends Animal {
	public String name = "Dog";
	
	@Override
	public void shout() {
		System.out.println("狗叫");
	}
	
	public void sleep() {
		System.out.println("狗休息");
	}
}

class Cat extends Animal {
	public String name = "Cat";
	
	public void shout() {
		System.out.println("猫叫");
	}
	
	public void search() {
		System.out.println("抓耗子");
	}
}

