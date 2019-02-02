package lixin.gan;

public class DeadLock {
	public static void main(String[] args) {
		new Thread(new Person("小明")).start();
		new Thread(new Person("小红")).start();
	}
}

class One{}
class Two{}

class Person implements Runnable {
	private static One one = new One();
	private static Two two = new Two();
	
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		// 如果是小明，则先用one，再用two；如果是小红，则先用two，再用one
		if (name.equals("小明")) {
			synchronized(one) {
				System.out.println(name + " 获得了 one");
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 休眠两秒后，使用two
				
				synchronized(two) {
					System.out.println(name + " 获得了 two");
				}
			}
		} else {
			synchronized(two) {
				System.out.println(name + " 获得了 two");
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 休眠两秒后，使用one
				
				synchronized(one) {
					System.out.println(name + " 获得了 one");
				}
			}
		}
	}
}

