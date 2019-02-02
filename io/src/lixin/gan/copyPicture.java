package lixin.gan;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * �����ļ�����Byte��ʵ���ļ��Ŀ���
 * @author 13550
 *
 */
public class copyPicture {
	public static void main(String[] args) throws IOException {
		// ��һ���� ���ļ����ݶ��뵽�ڴ��е�ByteArray��
		File pic = new File("demo.jpg");
		FileInputStream fileInputStream = new FileInputStream(pic);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		int length = -1;
		byte[] data = new byte[1024];
		while ((length = fileInputStream.read(data)) != -1) {
			byteArrayOutputStream.write(data, 0, length);
		}
		byteArrayOutputStream.flush();
		
		// �ڶ��������ڴ��е����ݣ�д�����ļ���
		byte[] picBytes = byteArrayOutputStream.toByteArray();
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(picBytes);
		File newPicture = new File("newpic.jpg");
		FileOutputStream fileOutputStream = new FileOutputStream(newPicture);
		while ((length = byteArrayInputStream.read(data)) != -1) {
			fileOutputStream.write(data, 0, length);
		}
		fileOutputStream.flush();
		fileOutputStream.close();
		fileInputStream.close();
		
	}
}
