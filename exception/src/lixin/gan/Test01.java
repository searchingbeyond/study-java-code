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
			
			// 注意，在catch时，子类异常要在父类异常之前，顺序不要颠倒
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("不管是否出现异常，都会执行finally中的代码");
		}
	}
}
