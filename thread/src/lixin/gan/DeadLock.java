package lixin.gan;

public class DeadLock {
	public static void main(String[] args) {
		new Thread(new Person("С��")).start();
		new Thread(new Person("С��")).start();
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
		// �����С����������one������two�������С�죬������two������one
		if (name.equals("С��")) {
			synchronized(one) {
				System.out.println(name + " ����� one");
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// ���������ʹ��two
				
				synchronized(two) {
					System.out.println(name + " ����� two");
				}
			}
		} else {
			synchronized(two) {
				System.out.println(name + " ����� two");
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// ���������ʹ��one
				
				synchronized(one) {
					System.out.println(name + " ����� one");
				}
			}
		}
	}
}

