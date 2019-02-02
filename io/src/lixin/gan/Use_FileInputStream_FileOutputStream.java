package lixin.gan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Use_FileInputStream_FileOutputStream {
	
	public static void useFileInputStream() {
		File file = new File("data.txt");
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			/*
			//һ�ζ�ȡ1���ֽڣ�����-1��ʱ�򣬱�ʾ��ȡ���ļ�ĩβ
			int byte1 = inputStream.read();	// ��ȡ��1���ֽ�
			int byte2 = inputStream.read(); // ��ȡ��2���ֽ�
			
			int tmp;
			while ((tmp = inputStream.read()) != -1) {
				System.out.print((char)tmp);
			}
			*/
			
			/*
			// �ֶζ�ȡ
			byte[] buf = new byte[5];
			int len = -1;
			while((len = inputStream.read(buf)) != -1) {
				System.out.println(new String(buf, 0, len));
			}
			*/
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != inputStream) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void useFileOutputStream() {
		File file = new File("data.txt");
		OutputStream outputStream = null;
		
		try {
			// �ļ������ڵĻ������Զ������ļ���Ĭ��������ļ���д������
			outputStream = new FileOutputStream(file);
			
			// ����ʹ�õڶ���������booleanֵ����ʾ׷��д��
			// outputStream = new FileOutputStream(file, true);
			
			String msg = "���hello world";
			byte[] data = msg.getBytes();
			outputStream.write(data, 0, data.length);
			outputStream.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != outputStream) {
					outputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void copyFile() {
		File src = new File("src.txt");
		File dest = new File("dest.txt");
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			inputStream = new FileInputStream(src);
			outputStream = new FileOutputStream(dest);
			
			byte[] buf = new byte[5];
			int length = -1;
			while ((length = inputStream.read(buf)) != -1) {
				outputStream.write(buf, 0, length);
			}
			
			outputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			if (null != outputStream) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		copyFile();
	}
}
