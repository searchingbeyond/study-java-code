package lixin.gan;

/**
 * ��������̳�Thread�࣬����дrun������Ȼ�󴴽�������󣬵���start()���������߲���ϵͳִ���̣߳�run������
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