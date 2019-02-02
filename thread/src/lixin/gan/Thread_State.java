package lixin.gan;

import java.lang.Thread.State;

/*
 * ThreadµÄ×´Ì¬
 */
public class Thread_State implements Runnable {

	/*
	Thread.State.NEW;
	Thread.State.RUNNABLE;
	Thread.State.WAITING;
	Thread.State.BLOCKED;
	Thread.State.TIMED_WAITING;
	Thread.State.TERMINATED;
	*/
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			if (i % 2 == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Thread_State());
		System.out.println(thread.getState());  // NEW
		
		thread.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(thread.getState());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
