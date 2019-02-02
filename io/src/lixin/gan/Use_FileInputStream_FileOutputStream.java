package lixin.gan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Use_FileInputStream_FileOutputStream {
	
	public static void useFileInputStream() {
		File file = new File("data.txt");
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			/*
			//一次读取1个字节，返回-1的时候，表示读取到文件末尾
			int byte1 = inputStream.read();	// 读取第1个字节
			int byte2 = inputStream.read(); // 读取第2个字节
			
			int tmp;
			while ((tmp = inputStream.read()) != -1) {
				System.out.print((char)tmp);
			}
			*/
			
			/*
			// 分段读取
			byte[] buf = new byte[5];
			int len = -1;
			while((len = inputStream.read(buf)) != -1) {
				System.out.println(new String(buf, 0, len));
			}
			*/
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != inputStream) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void useFileOutputStream() {
		File file = new File("data.txt");
		OutputStream outputStream = null;
		
		try {
			// 文件不存在的话，会自动创建文件，默认是清空文件后写入数据
			outputStream = new FileOutputStream(file);
			
			// 可以使用第二个参数，boolean值，表示追加写入
			// outputStream = new FileOutputStream(file, true);
			
			String msg = "你好hello world";
			byte[] data = msg.getBytes();
			outputStream.write(data, 0, data.length);
			outputStream.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != outputStream) {
					outputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void copyFile() {
		File src = new File("src.txt");
		File dest = new File("dest.txt");
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			inputStream = new FileInputStream(src);
			outputStream = new FileOutputStream(dest);
			
			byte[] buf = new byte[5];
			int length = -1;
			while ((length = inputStream.read(buf)) != -1) {
				outputStream.write(buf, 0, length);
			}
			
			outputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			if (null != outputStream) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		copyFile();
	}
}
