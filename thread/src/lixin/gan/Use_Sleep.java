package lixin.gan;

/**
 * Thread.Sleep(mills)���������õ�ǰ���߳����ߣ������� ���ٺ���
 */

public class Use_Sleep implements Runnable {
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " -> " + i);
			if (i == 5) {
				try {
					Thread.sleep(100);  
					// ��Ϊʵ��Runnable�ӿں�run�������������쳣��ֻ���ڲ����쳣���Ҵ����쳣
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Thread(new Use_Sleep(), "aaaa").start();
		
		System.out.println("yes");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
