package lixin.gan;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * TimerTask抽象类，需要有子类继承，并实现run方法，表示的就是这个任务需要做什么
 * Timer类可以比作一个闹钟，会开启一个线程去执行任务（并不是立即执行），而是当到达闹钟设定的时间，才会执行任务
 */
public class Use_Timer {
	public static void main(String[] args) {
		Timer timer = new Timer();
		
		/*
		// 开启一个新线程， 两秒之后去执行任务， 只执行一次
		timer.schedule(new MyTask(), 2000L);
		
		// 这句话会先于前面的任务输出
		System.out.println("hello");
		*/
		
		// 两秒之后开始执行任务，并且每隔200毫秒执行一次
		//timer.schedule(new MyTask(), 2000L, 200L);
		
		// 在指定时间开始执行任务
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

