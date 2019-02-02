package lixin.gan;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * TimerTask�����࣬��Ҫ������̳У���ʵ��run��������ʾ�ľ������������Ҫ��ʲô
 * Timer����Ա���һ�����ӣ��Ὺ��һ���߳�ȥִ�����񣨲���������ִ�У������ǵ����������趨��ʱ�䣬�Ż�ִ������
 */
public class Use_Timer {
	public static void main(String[] args) {
		Timer timer = new Timer();
		
		/*
		// ����һ�����̣߳� ����֮��ȥִ������ ִֻ��һ��
		timer.schedule(new MyTask(), 2000L);
		
		// ��仰������ǰ����������
		System.out.println("hello");
		*/
		
		// ����֮��ʼִ�����񣬲���ÿ��200����ִ��һ��
		//timer.schedule(new MyTask(), 2000L, 200L);
		
		// ��ָ��ʱ�俪ʼִ������
		// 2019-1-26 11:50:00
		GregorianCalendar gregorianCalendar = new GregorianCalendar(2019, 0, 26, 11, 50, 00);
		timer.schedule(new MyTask(), gregorianCalendar.getTime(), 1000L);
		
	}
}

class MyTask extends TimerTask {
	@Override
	public void run() {
		System.out.println("hello world " + new SimpleDateFormat("mm:ss").format(new Date()));
	}
}

