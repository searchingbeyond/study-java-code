package lixin.gan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		File file = new File("E:/demo/combine.bat");
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
		
		bufferedWriter.write("copy /b 1");
		for (int i = 2; i <= 699; i++) {
			bufferedWriter.write("+" + i);
		}
		bufferedWriter.write("new.ts");
		bufferedWriter.flush();
	}
}
