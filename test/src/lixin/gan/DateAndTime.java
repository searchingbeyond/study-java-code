package lixin.gan;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateAndTime {
	public static void main(String[] args) {
		// 获取当前系统的时间戳（毫秒数）
		long timeMillis = System.currentTimeMillis();
		System.out.println(timeMillis);  // 1547803604584
		
		// 利用当前的微秒时间戳来创建一个Date对象
		Date d = new Date();
		System.out.println(d);
		System.out.println(d.getTime()); // 获得毫秒数 1547803577897
		// Date类已经被废弃了，不推荐使用
		
		
		// DateFormat是一个抽象类, SimpleDateFormat是其实现类，需要传入格式
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String formatedDate = dateFormat.format(new Date());
		System.out.println(formatedDate); //2019-01-18 05:26:18
		// 简便写法
		// new SimpleDateFormat("yyyy-hh-dd hh:mm:ss").format(new Date());
		
		try {
			Date date = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒").parse("2019年01月18日 05时28分23秒");
			System.out.println(dateFormat.format(date));  // 2019-01-18 05:28:23
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		// Calendar类是抽象类， GregorianCalendar是实现类
		// 2019-7-20 10:20:30，可以不传参，表示将当前时间作为参数
		Calendar calendar = new GregorianCalendar(2019, 6, 20, 10, 20, 30);
		calendar.get(Calendar.YEAR);  // 2019
		System.out.println(calendar.get(Calendar.MONTH));  // 0对应1月，11对应12月
	}
}
