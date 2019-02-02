package lixin.gan;

public class UseEnum {
	public static void main(String[] args) {
		Season season = Season.SUMMER;
		System.out.println(season);
	}
}

enum Season {
	SPRING, SUMMER, AUTUMN, WINTER;
}

enum Week {
	MONDAY, TUESDAY, THIRSDAY, THUESDAY, FRIDAY, SATURDAY, SUNDAY;
}
