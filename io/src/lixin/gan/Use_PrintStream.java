package lixin.gan;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Use_PrintStream {
	public static void main(String[] args) throws FileNotFoundException {
		/**
		 * PrintStream ��ӡ��������System.out
		 */
		
		/**
		PrintStream out = System.out;
		out.println("hello");
		*/
		
		// ָ�������
		PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("demo.txt")));
		out.println("yes");
		
		// ����ͨ��System.setOut��ָ�������
		System.setOut(out);
		System.out.print("�����ݻ��������ָ���ĵط�");
		
		// FileDescriptor.out;// ��׼���
	}
}
