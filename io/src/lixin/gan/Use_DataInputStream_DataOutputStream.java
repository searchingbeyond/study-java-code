package lixin.gan;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Use_DataInputStream_DataOutputStream {
	/**
	 * DataInputStream �� DataOutputStream��װ����
	 * ��Ҫ��д��������룬�����˳���д����˳�򱣳�һ��
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
		
		// ��ȡд��������
		byte[] data = byteArrayOutputStream.toByteArray();
		
		
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
		DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
		System.out.println(dataInputStream.readUTF());
		System.out.println(dataInputStream.readInt());
		System.out.println(dataInputStream.readBoolean());
		System.out.println(dataInputStream.readChar());
		// �����˳��һ������Ӧ�ͻ�����������Ϣ
	}
}
