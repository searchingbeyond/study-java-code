package lixin.gan;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Use_ByteArrayInputStream_ByteArrayOutputStream {
	
	/**
	 * ByteArrayInputStream��ByteArrayOutputStream��˵������������ʱ���ڴ��еģ����Բ����ͷţ�����gc�Զ��ͷ�
	 * 
	 */
	
	public static void useByteArrayInputStream() {
		String msg = "hello world";
		byte[] data = msg.getBytes();
		InputStream inputStream = null;
		
		// ����ByteArrayInputStream��˵�����ݵ���Դ�ǡ��ڴ桱��Ҳ���������data
		
		try {
			inputStream = new ByteArrayInputStream(data);
			byte[] buf = new byte[5];
			int length = -1;
			while ((length = inputStream.read(buf)) != -1) {
				System.out.print(new String(buf, 0, length));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// ����ByteArrayInputStream��˵������Ҫ�ر�
			/*
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			*/
		}
		
	}
	
	public static void useByteArrayOutputStream() {
		// ByteArrayOutputStream�����丸�ӿ�OutputStreamû�еķ���
		// OutputStream outputStream = null;
		ByteArrayOutputStream outputStream = null;
		// ByteArrayOutputStream��dest���ڴ棬���Բ���Ҫָ��dest
		
		outputStream = new ByteArrayOutputStream();
		
		String msg = "hello world java";
		byte[] data = msg.getBytes(); // Ҫд���ڴ������
		
		// ������д��ByteArrayOutputStream��
		outputStream.write(data, 0, data.length);
		try {
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// ��ȡд�������
		byte[] content = outputStream.toByteArray();
		System.out.println(new String(content, 0, content.length));
		System.out.println(new String(content, 0, outputStream.size()));
		
	}
	
	public static void main(String[] args) {
		useByteArrayOutputStream();
	}
}
