package templetmethodTest;

import java.util.*;

public class TestMain5_selectWhereName {

	public static void main(String[] args) {
		DtoTest dao = new DtoTestImpl();
		Scanner ss = new Scanner(System.in);
		System.out.print("해당 회원의 이름을 입력해주세요 : ");
		String inputtext = ss.nextLine();
		ss.close();
		
		List<Ct>list = dao.nameCt(inputtext);
		for(Ct ct : list) {
			System.out.println(ct);
		}

	}

}
