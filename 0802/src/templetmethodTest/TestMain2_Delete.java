package templetmethodTest;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

public class TestMain2_Delete {

	public static void main(String[] args) {
		DtoTest dao  = new DtoTestImpl();
		Ct ct = new Ct();
		
		Scanner ss = new Scanner(System.in);
		
		System.out.print("삭제시킬 유저 번호를 입력해주세요! : ");
		int udnum = ss.nextInt();
		
		ss.close();
		
		
		//입력받은 번호에 해당하는 데이터들을 삭제하는 메소드 호출
		boolean result = dao.deleteCt(udnum);
		if(result == true) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제에 실패했습니다... 번호를 다시 확인해주세요.");
		}

	}

}
