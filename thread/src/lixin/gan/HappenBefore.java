package lixin.gan;

/**
 * ÿһ�д��붼�ᷭ��Ϊ����ָ� һ��ᰴ��ָ���˳��ִ�У� ��Ҳ���������
 * happen before��ָ�����������ϵͳ����CPU��ִ��ָ���ʱ�򣬺�һ�������ָ�� ���� ǰ��һ�������ָ����³��ֵ�����
 *
 */
public class HappenBefore {
	private static int a = 0;
	private static boolean flag = false;
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(()-> {
			a = 1;
			flag = true;
		});
		
		Thread t2 = new Thread(()->{
			if (flag) {
				a *= 1;
			}
			
			if (a == 0) {
				System.out.println("happen before a = " + a);
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
}
