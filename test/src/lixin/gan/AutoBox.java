package lixin.gan;

public class AutoBox {
	public static void main(String[] args) {
		
		Integer a = 234;
		// 自动装箱
		// 等价于 Integer a = Integer.valueOf(23

		int b = new Integer("444");
		// 自动拆箱
		// 等价于 int b = new Integer("444").intValue();
		
		// 对于Integer而言
		// -128 ~ 127之间的数，调用valueOf返回对象时，会有缓存，所以下面的判断结果为true
		Integer c1 = 127;
		Integer c2 = 127;
		System.out.println(c1 == c2);  // true
	}
}
