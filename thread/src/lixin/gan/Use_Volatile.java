package lixin.gan;

/*
 * Volatile������֤���ݵ�ͬ���������޸ĵĿɼ��ԣ������޸ĺ󣬺�������ʹ�øñ������̶߳Դ��޸Ĳ����ǿɼ���
 * ����֤ԭ���ԣ����Է�ָֹ�����ţ� ������Synchronized
 */
public class Use_Volatile {
	
	private static int num1 = 0; // not synchronized
	
	private volatile static int num2 = 0; // synchronized
	
	public static void main(String[] args) {
		demo1();
	}
	
	/**
	 * �������ݲ�һ��
	 */
	public static void demo1() {
		new Thread(()-> {
			while (num1 == 0) {
				// ��ѭ��
			}
		}).start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		num1 = 1;
	}
	
	public static void demo2() {
		new Thread(()-> {
			while (num2 == 0) {
				// ��ѭ��
			}
		}).start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		num2 = 1;
	}
	
}
