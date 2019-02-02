package lixin.gan;

public class UseString {
	
	public static void main(String[] args) {
		String str1 = "hello world";
		System.out.println(str1.charAt(4));   // o
		String str2 = "abc";
		String str3 = "abc";
		System.out.println(str2 == str3); 		// true
		// 对于对象来说，使用==判断的是地址是否相同，如果要判断内容是否相同，需要使用equals方法
		
		System.out.println(str2 == new String("hello world")); // false

		System.out.println("abcdefg".indexOf("cde"));
	}

}
