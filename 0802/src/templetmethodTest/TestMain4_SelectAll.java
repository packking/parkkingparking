package templetmethodTest;

import java.util.List;

public class TestMain4_SelectAll {

	public static void main(String[] args) {
		DtoTest dao  = new DtoTestImpl();
		List<Ct> list = dao.allreadCt();
//		System.out.println(list); list 내역 일괄출력
		for(Ct tablename : list) { //for each 구문 -> collection 내부에 있는 자료들을 일괄로 입출력 작업을 할 때에 씀
			System.out.println(tablename);	//row단위 씩 끊어서 찍게 해줌
		}
		


	}

}
