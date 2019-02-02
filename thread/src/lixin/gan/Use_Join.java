package lixin.gan;


/* 假设有thread1和thread2两个线程，两个线程合作完成一件任务，每一个线程完成一部分
 * thread2执行过程中，需要保证thread1执行完毕，thread2才能接着执行，那么只需要thread2调用thread1.Join()即可
 */
public class Use_Join {
	public static void main(String[] args) {
		My_Thread my_Thread = new My_Thread();
		Thread thread1 = new Thread(my_Thread, "AAA");
		thread1.start();
		
		try {
			thread1.join();
			// 等待thread1执行完毕后，在执行thread2
			
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
