package lixin.gan;


/* ������thread1��thread2�����̣߳������̺߳������һ������ÿһ���߳����һ����
 * thread2ִ�й����У���Ҫ��֤thread1ִ����ϣ�thread2���ܽ���ִ�У���ôֻ��Ҫthread2����thread1.Join()����
 */
public class Use_Join {
	public static void main(String[] args) {
		My_Thread my_Thread = new My_Thread();
		Thread thread1 = new Thread(my_Thread, "AAA");
		thread1.start();
		
		try {
			thread1.join();
			// �ȴ�thread1ִ����Ϻ���ִ��thread2
			
			Thread thread2 = new Thread(my_Thread, "BBB");
			thread2.start();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	
	}
}

class My_Thread implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " -> " + i);
		}
	}
}
