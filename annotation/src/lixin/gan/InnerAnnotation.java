package lixin.gan;

import java.util.Date;

public class InnerAnnotation {
	/*
	 * Java�����ж��ע�⣬����@Override, @Suppresswarning, @Deprecated....
	 * 
	 * @Override ��ʾ��д�����е�ͬ�����������������û�и�ͬ�������������ʾ�������
	 * @SuppressWarnings �������þ���ĵȼ���������������߷����г����˶�Ӧ�ľ���ʱ������ᱻ����
	 * @Deprecated ��ʾ���ǲ��Ƽ�ʹ��
	 */
	@Override
	public String toString() {
		return "hello world";
	}
	
	@Deprecated
	public void test() {
		Date d = new Date();
		d.getMinutes();
	}
	
	
	public void demo1() {
		int a = 0;
	}
	
	@SuppressWarnings("all")
	public void demo2() {
		// �����demo1���ԣ����ﶨ���˱���a������û��ʹ�ã�Ҳ������־���
		int a = 0;
	}
	
}
