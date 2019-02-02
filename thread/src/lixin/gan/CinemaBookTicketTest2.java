package lixin.gan;

import java.util.ArrayList;
import java.util.List;

public class CinemaBookTicketTest2 {
	public static void main(String[] args) {
		List<Integer> available = new ArrayList<>();
		for (int i = 1; i <= 20; i++) {
			available.add(i);
		}
		AdvancedCinema cinema = new AdvancedCinema(available, "CCTV");
		
		List<Integer> a1 = new ArrayList<>();
		a1.add(1);a1.add(2);a1.add(5);a1.add(7);
		
		List<Integer> a2 = new ArrayList<>();
		a2.add(1);a2.add(2);a2.add(3);a2.add(4);
		
		List<Integer> a3 = new ArrayList<>();
		a3.add(8);a3.add(9);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(new AdvancedCustomer(cinema, a1), "a1").start();
		new Thread(new AdvancedCustomer(cinema, a2), "a2").start();
		new Thread(new AdvancedCustomer(cinema, a3), "a3").start();
		
	}
}

// �˿�
class AdvancedCustomer implements Runnable {
	AdvancedCinema cinema = null;
	
	List<Integer> num;
	
	public AdvancedCustomer(AdvancedCinema cinema, List<Integer> num) {
		super();
		this.cinema = cinema;
		this.num = num;
	}

	@Override
	public void run() {
		synchronized(cinema) {
			boolean flag = cinema.bookTicket(num);
			if (flag) {
				System.out.println("��Ʊ�ɹ� " + Thread.currentThread().getName() + " λ��Ϊ " + num );
			} else {
				System.out.println("��Ʊʧ��" + Thread.currentThread().getName() + " λ��Ϊ " + num);
			}
		}
	}
}

// ����ѡ��λ����Ʊ��
class AdvancedCinema {
	List<Integer> available; // ���õ�λ��
	String name;  // ����
	
	public AdvancedCinema(List<Integer> available, String name) {
		super();
		this.available = available;
		this.name = name;
	}

	public boolean bookTicket(List<Integer> num) {
		System.out.println("����λ��Ϊ ->  " + available);
		
		List<Integer> copy = new ArrayList<>();
		copy.addAll(available);
		
		copy.removeAll(num);
		
		if (available.size() - copy.size() != num.size()) {
			return false;
		} else {
			available = copy;
			return true;
		}
	}
}
