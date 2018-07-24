package test;

import java.util.*;
import java.sql.Date;
public class Main {

	public static void main(String[] args) {	
		ArrayList<DTO>userlist = new ArrayList<>();

		DTO user01 = new DTO();
		user01.setNum(1);
		user01.setName("임꺽정");
		user01.setResult(79);
		Date d = new Date(-372,10,11);
		user01.setBirthDate(d);

		DTO user02 = new DTO();
		user02.setNum(2);
		user02.setName("신창원");
		user02.setResult(27);
		d = new Date(67,4,28);	//년은 기본적으로 +1900, 월은 +1
		user02.setBirthDate(d);
		
		DTO user03 = new DTO();
		user03.setNum(3);
		user03.setName("김재규");
		user03.setResult(90);
		d = new Date(26,2,6);
		user03.setBirthDate(d);
		
		DTO user04 = new DTO();
		user04.setNum(4);
		user04.setName("이인제");
		user04.setResult(88);
		d = new Date(48,11,11);
		user04.setBirthDate(d);
		
		DTO user05 = new DTO();
		user05.setNum(5);
		user05.setName("김두한");
		user05.setResult(85);
		d = new Date(18,4,15);
		user05.setBirthDate(d);
			
		userlist.add(user01);
		userlist.add(user02);
		userlist.add(user03);
		userlist.add(user04);
		userlist.add(user05);
		
		
		Comparator<DTO>comp = new Comparator() {

			@Override
			public int compare(Object a, Object b) {
				DTO first = (DTO)a;
				DTO second = (DTO)b;
				return first.getResult() - second.getResult();
			}	
		};
		userlist.sort(comp);
		
		System.out.println(userlist);
	}

}
