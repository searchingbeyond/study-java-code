package lixin.gan;

/**
 * 创建子类继承Thread类，并重写run方法，然后创建子类对象，调用start()方法来告诉操作系统执行线程（run方法）
 */

public class CreateThread_1 {
	public static void main(String[] args) {
		MyThread1 myThread = new MyThread1();
		myThread.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("hello main " + i);
		}
	}
}


class MyThread1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("hello thread " + i);
		}
	}
}