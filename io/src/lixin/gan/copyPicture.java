package lixin.gan;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * 利用文件流和Byte流实现文件的拷贝
 * @author 13550
 *
 */
public class copyPicture {
	public static void main(String[] args) throws IOException {
		// 第一步： 将文件数据读入到内存中的ByteArray中
		File pic = new File("demo.jpg");
		FileInputStream fileInputStream = new FileInputStream(pic);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		int length = -1;
		byte[] data = new byte[1024];
		while ((length = fileInputStream.read(data)) != -1) {
			byteArrayOutputStream.write(data, 0, length);
		}
		byteArrayOutputStream.flush();
		
		// 第二步：将内存中的数据，写入新文件中
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
