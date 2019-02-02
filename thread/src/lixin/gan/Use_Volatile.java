package lixin.gan;

/*
 * Volatile用来保证数据的同步，数据修改的可见性，数据修改后，后面其他使用该变量的线程对此修改操作是可见的
 * 不保证原子性，可以防止指令重排， 轻量级Synchronized
 */
public class Use_Volatile {
	
	private static int num1 = 0; // not synchronized
	
	private volatile static int num2 = 0; // synchronized
	
	public static void main(String[] args) {
		demo1();
	}
	
	/**
	 * 存在数据不一致
	 */
	public static void demo1() {
		new Thread(()-> {
			while (num1 == 0) {
				// 死循环
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
				// 死循环
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
