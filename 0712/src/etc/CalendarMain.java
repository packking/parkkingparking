package etc;

import java.util.Calendar;
import java.util.Date;

public class CalendarMain {
	public static void main(String [] args) {
		//1986년 5월 5일을 Calendar 객체로 만들기
		Calendar meetDay = Calendar.getInstance();
		meetDay.set(Calendar.YEAR, 1986);
		meetDay.set(Calendar.MONTH, 4);
		meetDay.set(Calendar.DAY_OF_MONTH, 5);
		//System.out.println(meetDay);
		//Date date = new Date(meetDay.getTimeInMillis());
		//System.out.println(date);
		
		Calendar toDay = Calendar.getInstance();
		long gap = 
			toDay.getTimeInMillis() - meetDay.getTimeInMillis();
		System.out.println("제시카를 만난지 " + (gap/24/60/60/1000) +
			"일 째 되는 날 입니다.");
		
	}
}