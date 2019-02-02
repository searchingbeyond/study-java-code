package lixin.gan;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Use_ByteArrayInputStream_ByteArrayOutputStream {
	
	/**
	 * ByteArrayInputStream和ByteArrayOutputStream来说，操作的数据时在内存中的，所以不用释放，交由gc自动释放
	 * 
	 */
	
	public static void useByteArrayInputStream() {
		String msg = "hello world";
		byte[] data = msg.getBytes();
		InputStream inputStream = null;
		
		// 对于ByteArrayInputStream来说，数据的来源是“内存”，也就是上面的data
		
		try {
			inputStream = new ByteArrayInputStream(data);
			byte[] buf = new byte[5];
			int length = -1;
			while ((length = inputStream.read(buf)) != -1) {
				System.out.print(new String(buf, 0, length));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 对于ByteArrayInputStream来说，不需要关闭
			/*
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			*/
		}
		
	}
	
	public static void useByteArrayOutputStream() {
		// ByteArrayOutputStream中有其父接口OutputStream没有的方法
		// OutputStream outputStream = null;
		ByteArrayOutputStream outputStream = null;
		// ByteArrayOutputStream的dest是内存，所以不需要指定dest
		
		outputStream = new ByteArrayOutputStream();
		
		String msg = "hello world java";
		byte[] data = msg.getBytes(); // 要写入内存的数据
		
		// 将数据写入ByteArrayOutputStream中
		outputStream.write(data, 0, data.length);
		try {
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 获取写入的数据
		byte[] content = outputStream.toByteArray();
		System.out.println(new String(content, 0, content.length));
		System.out.println(new String(content, 0, outputStream.size()));
		
	}
	
	public static void main(String[] args) {
		useByteArrayOutputStream();
	}
}
