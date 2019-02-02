package lixin.gan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Use_RandomAccesssFile {
	
	/**
	 * RandomAccessFile可以随机读取和写入文件内容，读取方式是流
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile(new File("demo.txt"), "r");
		
		randomAccessFile.seek(100);  // 指定偏移
		
		byte[] buf = new byte[1024];
		int length = -1;
		while ((length = randomAccessFile.read(buf)) != -1) {
			
		}
	}
}
