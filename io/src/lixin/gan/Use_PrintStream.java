package lixin.gan;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Use_PrintStream {
	public static void main(String[] args) throws FileNotFoundException {
		/**
		 * PrintStream 打印流，比如System.out
		 */
		
		/**
		PrintStream out = System.out;
		out.println("hello");
		*/
		
		// 指定输出端
		PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("demo.txt")));
		out.println("yes");
		
		// 可以通过System.setOut来指定输出端
		System.setOut(out);
		System.out.print("该内容会输出到新指定的地方");
		
		// FileDescriptor.out;// 标准输出
	}
}
