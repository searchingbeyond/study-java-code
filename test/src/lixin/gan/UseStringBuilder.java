package lixin.gan;

public class UseStringBuilder {
	public static void main(String[] args) {
		// String是不可变字符串类
		// StringBuilder和StringBuffer是可变字符串类
		
		/*
		//下面是两种用法的对比
		String s = "";
		for (int i = 0; i < 500; i++) {
			s = s + i;  
		}
		// 创建1000个对象
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 500; i++) {
			sb.append(i);  
		}
		// 只创建了一个对象
		*/
		
		
		StringBuilder strbuilder = new StringBuilder();
		StringBuffer strbuffer = new StringBuffer();
		// StringBuilder线程不安全，效率高
		// StringBuffer线程安全
		// StringBuilder和StringBuffer的用法相同
		
		// 追加内容
		strbuilder.append("hello ");
		strbuilder.append("world");
		System.out.println(strbuilder);
		
		// 将字符串倒序，并返回对象本身（字符串内容已经倒序）
		StringBuilder reversedStr = strbuilder.reverse();
		System.out.println(strbuilder == reversedStr); // true
		
		// 修改某个位置的值
		strbuilder.setCharAt(3, 'x');
		System.out.println(strbuilder);
		
		// 中间位置插入，返回对象本身
		strbuilder.insert(3, 'y').insert(4, 'z');
		System.out.println(strbuilder);
		
		// 删除
		strbuilder.deleteCharAt(0).delete(3, 6);
		System.out.println(strbuilder);
	}
}
