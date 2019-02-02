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
			// һ�ζ�ȡһ���ַ�
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
			// ��պ�д��
			writer = new FileWriter(file);
			
			// ׷��д��
			// writer = new FileWriter(file, true);
			
			/*
			writer.write(99); // д��һ���ַ�
			*/
			
			/*
			����ֱ��д���ַ���
			writer.write("hello world");
			*/
			
			/*
			// д���ַ�����
			String msg = "���ѽhello world";
			char[] data = msg.toCharArray();
			writer.write(data, 0, data.length);
			 */
			
			/*
			//ʹ��append׷��д
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
