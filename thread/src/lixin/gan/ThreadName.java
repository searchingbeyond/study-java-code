package lixin.gan;

/*
 * 如果实现Runnable接口后，利用Thread代理类来启动线程，传递给代理类的线程名称是代理线程名称，而真实线程的名称可以使用属性的方法来实现。
 */
public class ThreadName implements Runnable {
	private String threadName;
	
	public ThreadName() {
		super();
	}

	public ThreadName(String threadName) {
		super();
		this.threadName = threadName;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public void run() {
		System.out.println("真实线程的名称 -> " + this.getThreadName());
		System.out.println("代理类线程的名称 -> " + Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		new Thread(new ThreadName("real threadName"), "proxy threadName").start();
	}
}
