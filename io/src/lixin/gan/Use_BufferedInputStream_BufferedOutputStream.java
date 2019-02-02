package lixin.gan;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Use_BufferedInputStream_BufferedOutputStream {
	
	// BufferedInputStream 和 BufferedOutputStream是包装流，需要传入节点流进行包装
	
	public static void useBufferedInputStream() {
		File file = new File("demo.jpg");
		FileInputStream fileInputStream = null;
		BufferedInputStream bufferedInputStream = null;
		
		try {
			fileInputStream = new FileInputStream(file);
			
			bufferedInputStream = new BufferedInputStream(fileInputStream);
			
			byte[] buf = new  byte[1024];
			int length = -1;
			while ((length = bufferedInputStream.read(buf)) != -1) {
				 System.out.println(length);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bufferedInputStream != null) {
				try {
					bufferedInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void useBufferedOutputStream() {
		File file = new File("demo.txt");
		FileOutputStream fileOutputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
			bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			
			String msg = "hello world";
			byte[] data = msg.getBytes();
			bufferedOutputStream.write(data, 0, data.length);
			bufferedOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != fileOutputStream) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (null != bufferedOutputStream) {
				try {
					bufferedOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		useBufferedOutputStream();
	}
}
