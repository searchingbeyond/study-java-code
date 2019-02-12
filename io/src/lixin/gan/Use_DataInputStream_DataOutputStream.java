package lixin.gan;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Use_DataInputStream_DataOutputStream {
	/**
	 * DataInputStream 和 DataOutputStream是装饰流
	 * 需要先写出，后读入，读入的顺序和写出的顺序保持一致
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
		dataOutputStream.writeUTF("hello");
		dataOutputStream.writeInt(99);
		dataOutputStream.writeBoolean(true);
		dataOutputStream.writeChar('a');
		dataOutputStream.flush();
		
		// 获取写出的数据
		byte[] data = byteArrayOutputStream.toByteArray();
		
		
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
		DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
		System.out.println(dataInputStream.readUTF());
		System.out.println(dataInputStream.readInt());
		System.out.println(dataInputStream.readBoolean());
		System.out.println(dataInputStream.readChar());
		// 上面的顺序一旦不对应就会读到错误的信息
	}
}
