package lixin.gan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Test01 {
	public static void main(String[] args) {
		//System.out.println(5 / 0);  // java.lang.ArithmeticException
		
		/*
		String s = null;
		s.toCharArray();  // java.lang.NullPointerException
		*/
	     
		File file = new File("data.txt");
		try {
			InputStream inputStream = new FileInputStream(file);
			
			int a = inputStream.read();
			
			// ע�⣬��catchʱ�������쳣Ҫ�ڸ����쳣֮ǰ��˳��Ҫ�ߵ�
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("�����Ƿ�����쳣������ִ��finally�еĴ���");
		}
	}
}
