package lixin.gan;

import java.io.UnsupportedEncodingException;

public class EncodeAndDecode {
	public static void main(String[] args) {
	
	}
	
	public static void Encode() {
		// ԭ����
		String str = "����string";
		
		// ���б���
		byte[] data = null;
		try {
			// ���Բ������ַ������ʽ��������Ŀ�ı������ת��
			data = str.getBytes();
			
			// Ҳ�ɴ���ָ�����ַ������ʽ
			data = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(data.length);
	}
	
	public static void Decode() {
		String str = "����string";
		
		byte[] data = null;  // data���������Ѿ������������
		try {
			data = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// ���Ѿ�����������ݽ��н���
		String msg = null;
		try {
			msg = new String(data, 0, data.length, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(msg);
		
		// �������ͽ�����ַ�������ͬ������������
	}
}
