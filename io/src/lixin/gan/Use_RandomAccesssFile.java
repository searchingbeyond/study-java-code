package lixin.gan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Use_RandomAccesssFile {
	
	/**
	 * RandomAccessFile���������ȡ��д���ļ����ݣ���ȡ��ʽ����
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile(new File("demo.txt"), "r");
		
		randomAccessFile.seek(100);  // ָ��ƫ��
		
		byte[] buf = new byte[1024];
		int length = -1;
		while ((length = randomAccessFile.read(buf)) != -1) {
			
		}
	}
}
