package lixin.gan;


/*
 * ThreadLocal����Ϊÿ���̱߳��治ͬ��ֵ
 * InheritableThreadLocal���Թ������������ݣ�������
 */
public class Use_ThreadLocal {

	private static ThreadLocal threadLocal = new ThreadLocal();
	
	public static void main(String[] args) {
		new Thread(()->{
			threadLocal.set(5);
			System.out.println(Thread.currentThread().getName() + " -> " + threadLocal.get());
		}).start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(()->{
			System.out.println(Thread.currentThread().getName() + " -> " + threadLocal.get());
		}).start();
		
		/*
		 * Thread-0 -> 5
		 * Thread-1 -> null
		 */
	}
}
