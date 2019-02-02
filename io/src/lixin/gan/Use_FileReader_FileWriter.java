package lixin.gan;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Use_FileReader_FileWriter {
	
	public static void useFileReader() {
		File file = new File("data.txt");
		Reader reader = null;
		
		try {
			reader = new FileReader(file);
			/*
			// 一次读取一个字符
			int ch = -1;
			while ((ch = reader.read()) != -1) {
				System.out.print((char)ch);
			}
			*/
			
			char[] data = new char[5];
			int length = -1;
			while ((length = reader.read(data)) != -1) {
				System.out.print(new String(data, 0, length));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void useFileWriter() {
		File file = new File("data.txt");
		Writer writer= null;
		
		try {
			// 清空后写入
			writer = new FileWriter(file);
			
			// 追加写入
			// writer = new FileWriter(file, true);
			
			/*
			writer.write(99); // 写入一个字符
			*/
			
			/*
			可以直接写入字符串
			writer.write("hello world");
			*/
			
			/*
			// 写入字符数组
			String msg = "你好呀hello world";
			char[] data = msg.toCharArray();
			writer.write(data, 0, data.length);
			 */
			
			/*
			//使用append追加写
			writer.append("hello ").append("world");
			*/
			
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		useFileWriter();
	}
	
	
	
}
