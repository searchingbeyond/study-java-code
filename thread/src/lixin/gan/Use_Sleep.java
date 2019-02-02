package lixin.gan;

/**
 * Thread.Sleep(mills)方法，会让当前的线程休眠（阻塞） 多少毫秒
 */

public class Use_Sleep implements Runnable {
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " -> " + i);
			if (i == 5) {
				try {
					Thread.sleep(100);  
					// 因为实现Runnable接口后，run方法不能声明异常，只能在捕获异常并且处理异常
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
