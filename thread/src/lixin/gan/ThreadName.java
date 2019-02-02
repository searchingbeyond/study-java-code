package lixin.gan;

/*
 * ���ʵ��Runnable�ӿں�����Thread�������������̣߳����ݸ���������߳������Ǵ����߳����ƣ�����ʵ�̵߳����ƿ���ʹ�����Եķ�����ʵ�֡�
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
		System.out.println("��ʵ�̵߳����� -> " + this.getThreadName());
		System.out.println("�������̵߳����� -> " + Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		new Thread(new ThreadName("real threadName"), "proxy threadName").start();
	}
}
