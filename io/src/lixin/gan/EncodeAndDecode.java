package lixin.gan;

import java.io.UnsupportedEncodingException;

public class EncodeAndDecode {
	public static void main(String[] args) {
	
	}
	
	public static void Encode() {
		// 原内容
		String str = "这是string";
		
		// 进行编码
		byte[] data = null;
		try {
			// 可以不传入字符编码格式，则按照项目的编码进行转换
			data = str.getBytes();
			
			// 也可传入指定的字符编码格式
			data = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(data.length);
	}
	
	public static void Decode() {
		String str = "这是string";
		
		byte[] data = null;  // data用来保存已经编码过得数据
		try {
			data = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 将已经编码过的数据进行解码
		String msg = null;
		try {
			msg = new String(data, 0, data.length, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(msg);
		
		// 如果编码和解码的字符集不相同，则会出现乱码
	}
}
