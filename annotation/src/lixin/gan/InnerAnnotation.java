package lixin.gan;

import java.util.Date;

public class InnerAnnotation {
	/*
	 * Java内置有多个注解，比如@Override, @Suppresswarning, @Deprecated....
	 * 
	 * @Override 表示重写父类中的同名方法，如果父类中没有该同名方法，则会提示编译错误
	 * @SuppressWarnings 可以设置警告的等级，当所处的类或者方法中出现了对应的警告时，警告会被忽略
	 * @Deprecated 表示的是不推荐使用
	 */
	@Override
	public String toString() {
		return "hello world";
	}
	
	@Deprecated
	public void test() {
		Date d = new Date();
		d.getMinutes();
	}
	
	
	public void demo1() {
		int a = 0;
	}
	
	@SuppressWarnings("all")
	public void demo2() {
		// 相对于demo1而言，这里定义了变量a，但是没有使用，也不会出现警告
		int a = 0;
	}
	
}
