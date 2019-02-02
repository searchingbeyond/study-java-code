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
	 * InputStreamReader �� OutputStreamWriter��ת����
	 * InputStreamReader�Ǵ��ֽ������ַ�������������ȡ�ֽڣ���ʹ��ָ����charset�������Ϊ�ַ�
	 * OutputStreamWriter�Ǵ��ַ������ֽ�����������ʹ��ִ�е�charset������д����ַ�����Ϊ�ֽ�
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;  // �ֽ���
		// ���ֽ���ת��Ϊ�ַ���
		InputStreamReader inputStreamReader = new InputStreamReader(in);
		// InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		PrintStream out = System.out; // �ֽ���
		// ���ֽ���ת��Ϊ�ַ���
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
		//OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		
		String msg = "";
		while (! msg.equals("quit")) {
			msg = bufferedReader.readLine(); // ��ȡһ��
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
