package lixin.gan;

import javax.sound.midi.Soundbank;

public class CinemaBookTicketTest1 {
	public static void main(String[] args) {
		Cinema cinema = new Cinema(20, "CCTV");
		new Thread(new Customer(cinema, 3), "aaa").start();
		new Thread(new Customer(cinema, 2), "bbb").start();
		new Thread(new Customer(cinema, 5), "ccc").start();
		new Thread(new Customer(cinema, 4), "ddd").start();
		new Thread(new Customer(cinema, 14), "eee").start();
	}
}

// �˿�
class Customer implements Runnable {
	Cinema cinema = null;
	
	int num;
	
	public Customer(Cinema cinema, int num) {
		super();
		this.cinema = cinema;
		this.num = num;
	}

	@Override
	public void run() {
		synchronized(cinema) {
			boolean flag = cinema.bookTicket(num);
			if (flag) {
				System.out.println("��Ʊ�ɹ� " + Thread.currentThread().getName() + " ����Ϊ " + num );
			} else {
				System.out.println("��Ʊʧ��" + Thread.currentThread().getName() + " ����Ϊ " + num);
			}
		}
	}
}

// ��Ʊ��
class Cinema {
	int available; // ���õ�λ��
	String name;  // ����
	public Cinema(int available, String name) {
		super();
		this.available = available;
		this.name = name;
	}
	
	public boolean bookTicket(int num) {
		System.out.println("����λ��Ϊ ->  " + available);
		if (num > available) {
			return false;
		} else {
			available -= num;
			return true;
		}
	}
}
