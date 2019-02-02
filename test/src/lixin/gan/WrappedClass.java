package lixin.gan;

public class WrappedClass {
	public static void main(String[] args) {
		Integer a = new Integer(3);
		Integer b = Integer.valueOf(3);
		System.out.println(a == b);  // false
		System.out.println(a.equals(b));// true
		
		int c = b.intValue();
		double d = b.doubleValue();
		
		Integer e = new Integer("999");
		//Integer f = new Integer("999.8");// wrong
		System.out.println(e);	// 999
		
		Integer f = Integer.parseInt("1000000", 2);
		System.out.println(f);  // 64
		
		Integer g = Integer.parseInt("999");
		System.out.println(g);
		
		// 常用常量
		System.out.println(Integer.MAX_VALUE + " " + Integer.MIN_VALUE);
		
		Integer h = new Integer("9999");
		String s = h.toString();
		// 等价于
		// s = "" + h;
		System.out.println(s);
	}
}
