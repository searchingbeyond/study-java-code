package lixin.gan;

/**
 * 每一行代码都会翻译为机器指令， 一般会按照指令的顺序执行， 但也有意外情况
 * happen before是指虚拟机、操作系统或者CPU在执行指令的时候，后一条代码的指令 先于 前面一条代码的指令，导致出现的问题
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
