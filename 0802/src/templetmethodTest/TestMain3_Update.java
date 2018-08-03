package templetmethodTest;

import java.sql.Date;
import java.util.*;

public class TestMain3_Update {

	public static void main(String[] args) {
				//인터페이스나 클래스를 상속한 경우에는
				//상위 인터페이스나 클래스 이름으로 변수를 만들고
				//하위 클래스의 인스턴스를 생성해서 대입합니다.
				DtoTest dao  = new DtoTestImpl();
				Ct ct = new Ct();
				
				Scanner ss = new Scanner(System.in);
				
				System.out.print("수정하실 유저 번호를 입력해주세요! : ");
				int udnum = ss.nextInt();
				System.out.print("이름을 수정해주세요. : ");
				ss.nextLine();
				String udname= ss.nextLine();
				System.out.print("전화번호를 수정해주세요. : ");
				String udpnum= ss.nextLine();
				System.out.print("주소를 수정해주세요 : ");
				String udaddress= ss.nextLine();
//				System.out.print("생년월일을 수정해주세요 : ");
//				String udbirthday= ss.nextLine();
				System.out.print("태어나신 년도를 입력해주세요. : ");
				int udyear = ss.nextInt();
				System.out.print("태어나신 달을 입력해주세요. : ");
				ss.nextLine();
				int udmonth = ss.nextInt();
				System.out.print("태어나신  일을 입력해주세요. : ");
				ss.nextLine();
				int udday = ss.nextInt();
				
				ss.close();
				
				
				ct.setNum(udnum);
				ct.setName(udname);
				ct.setPnum(udpnum);
				ct.setAddress(udaddress);
				
				Calendar cal = Calendar.getInstance();	//현재 시간을 저장한 캘린더 생성
				cal.set(Calendar.YEAR, udyear);	//캘린더의 년
				cal.set(Calendar.MONTH,udmonth);		//월
				cal.set(Calendar.DAY_OF_MONTH,udday);	//일
				Date birthday = 
					new Date(cal.getTimeInMillis());
				ct.setBirthday(birthday);
				
				
				//입력받은 번호에 해당하는 데이터를 수정하는 메소드 호출
				boolean result = dao.updateCt(ct);
				if(result == true) {
					System.out.println("수정 성공");
				}else {
					System.out.println("수정 실패");
				}

	}

}
