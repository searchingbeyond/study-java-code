package lixin.gan.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.sun.xml.internal.ws.spi.db.DatabindingException;

/*
 * �����ͻ��˶�����
 * 1��ʹ��Socket�����ͷ����������ӣ� ָ���������˵�ip��port
 * 2���������������
 * 3���ر�����
 * 
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//Creates a stream socket and connects it to the specified portnumber on the named host. 
		Socket connection = new Socket("localhost", 8888);
		
		// ������ӵ���
		//connection.getOutputStream();
		
		DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
		dataOutputStream.writeUTF("hello world");
		dataOutputStream.writeBoolean(false);
		dataOutputStream.flush();
		dataOutputStream.close();
		
		connection.close();
		
	}
}
