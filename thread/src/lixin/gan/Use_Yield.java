package lixin.gan;

/**
 * Thread.Yield()是将当前的线程有运行态变为就绪态，也就是释放时间片
 */

public class Use_Yield implements Runnable {
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if (i % 5 == 0) {
				Thread.yield();  // 让出时间片
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
