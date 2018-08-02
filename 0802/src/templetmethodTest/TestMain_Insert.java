package templetmethodTest;

import java.sql.Date;
import java.util.Calendar;

public class TestMain_Insert {

	public static void main(String[] args) {
		//인터페이스나 클래스를 상속한 경우에는
		//상위 인터페이스나 클래스 이름으로 변수를 만들고
		//하위 클래스의 인스턴스를 생성해서 대입합니다.
		DtoTest dao  = new DtoTestImpl();
		Ct ct = new Ct();
		
		ct.setNum(1);
		ct.setName("김진수");
		ct.setPnum("010-1234-5678");
		ct.setAddress("양천");
		
		Calendar cal = Calendar.getInstance();	//현재 시간을 저장한 캘린더 생성
		cal.set(Calendar.YEAR, 1970);	//캘린더의 년
		cal.set(Calendar.MONTH,5);		//월
		cal.set(Calendar.DAY_OF_MONTH,30);	//일
		Date birthday = 
			new Date(cal.getTimeInMillis());
		ct.setBirthday(birthday);
		
		
		//데이터를 삽입하는 메소드 호출
		boolean result = dao.insertCt(ct);
		if(result == true) {
			System.out.println("삽입 성공");
		}else {
			System.out.println("삽입 실패");
		}
	}

}
