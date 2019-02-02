package lixin.gan;

/**
 * 实现Runnable接口，并重写run方法
 */
public class CreateThread_2 {
	public static void main(String[] args) {
		/*
		MyThread2 myThread = new MyThread2();
		Thread thread = new Thread(myThread);
		thread.start();
		*/
		
		/*
		new Thread(new MyThread2()).start();
		*/
		
		/*
		new Thread(new Runnable(){
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("mythread print " + i);
				}
			}
		}).start();
		*/
		
		/*		
 		new Thread(() -> {
				for (int i = 0; i < 10; i++) {
					System.out.println("mythread print " + i);
				}
		}).start();
		*/
		
		for (int i = 0; i < 10; i++) {
			System.out.println("main print " + i);
		}
		
	}
}

class MyThread2 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("mythread print " + i);
		}
	}
}