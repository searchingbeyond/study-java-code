package lixin.gan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class Use_InputStreamReader_OutputStreamWriter {
	/**
	 * InputStreamReader 和 OutputStreamWriter是转换流
	 * InputStreamReader是从字节流到字符流的桥梁，读取字节，并使用指定的charset将其解码为字符
	 * OutputStreamWriter是从字符流到字节流的桥梁，使用执行的charset，将其写入的字符编码为字节
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;  // 字节流
		// 将字节流转换为字符流
		InputStreamReader inputStreamReader = new InputStreamReader(in);
		// InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		PrintStream out = System.out; // 字节流
		// 将字节流转换为字符流
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
		//OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		
		String msg = "";
		while (! msg.equals("quit")) {
			msg = bufferedReader.readLine(); // 读取一行
			bufferedWriter.write(msg);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
		
		if (null != inputStreamReader) {
			inputStreamReader.close();
		}
		if (null != bufferedReader) {
			bufferedReader.close();
		}
		if (null != outputStreamWriter) {
			outputStreamWriter.close();
		}
		if (null != bufferedWriter) {
			bufferedWriter.close();
		}
	}
}
