package lixin.gan;

public class ExtendsTree {
	public static void main(String[] args) {
		new Child();
	}
}

class Base{
	static {
		System.out.println("执行Base的静态初始化块");
	}
	
	public Base() {
		System.out.println("执行Base的构造方法");
	}
}

class Father extends Base {
	static {
		System.out.println("执行Father的静态初始化块");
	}
	
	public Father() {
		System.out.println("执行Father的构造方法");
	}
}

class Child extends Father {
	static {
		System.out.println("执行Child的静态初始化块");
	}
	
	public Child() {
		System.out.println("执行Child的构造方法");
	}
}