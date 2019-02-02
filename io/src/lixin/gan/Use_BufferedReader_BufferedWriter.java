package lixin.gan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Use_BufferedReader_BufferedWriter {
	
	/**
	 * BufferedReader �� BufferedWriter�ǰ�װ��
	 */
	
	public static void useBufferdReader() {
		File file = new File("demo.txt");
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			/*
		 	//���Ƽ�ʹ��
			char[] buf = new char[10];
			int length = -1;
			while ((length = bufferedReader.read(buf)) != -1) {
				
			}
			*/
			
			/*
			// �Ƽ�ʹ��
			String line = null;
			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			 */
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void useBufferedWriter() {
		File file = new File("demo.txt");
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write("hey1");
			bufferedWriter.newLine();  // ��ת����һ�е����ף��൱��д��һ�����з���
			bufferedWriter.write("hey2");
			bufferedWriter.newLine();
			bufferedWriter.write("hey3");
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		useBufferedWriter();
	}
}
