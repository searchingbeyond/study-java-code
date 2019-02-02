package lixin.gan;

/**
 * Thread.Yield()�ǽ���ǰ���߳�������̬��Ϊ����̬��Ҳ�����ͷ�ʱ��Ƭ
 */

public class Use_Yield implements Runnable {
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if (i % 5 == 0) {
				Thread.yield();  // �ó�ʱ��Ƭ
			}
			System.out.println(Thread.currentThread().getName() + " --> " + i);
		}
	}
	
	public static void main(String[] args) {
		Use_Yield use_yeild = new Use_Yield();
		new Thread(use_yeild, "AAAAA").start();
		new Thread(use_yeild, "BBBBB").start();
	}
}
