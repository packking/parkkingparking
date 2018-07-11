package pack01;

import java.util.*;

public class Main4 {

	public static void main(String[] args) {
		ArrayList<p01> list = new ArrayList<>();
		p01 pp1 = new p01();
		pp1.setName("김상주");
		pp1.setAge(22);
		list.add(pp1);	//pp1에 입력된 값들을 list에 넣음
		
		pp1 = new p01();
		pp1.setName("오민석");
		pp1.setAge(31);
		list.add(pp1);
		
		pp1 = new p01();
		pp1.setName("진성");
		pp1.setAge(27);
		list.add(pp1);
		
		pp1 = new p01();
		pp1.setName("안지영");
		pp1.setAge(29);
		list.add(pp1);
		
		//리스트 데아터 확인
//		System.out.println(list);
//		//데이터 각각 확인
//		for(p01 aa : list) {		//for(클래스명 변수명 : 참조형데이터명칭)
//			System.out.println(aa);
//		}
		
		Comparator<p01>comp = new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				p01 first = (p01)o1;
				p01 second = (p01)o2;
				return first.getAge() - second.getAge();	//개인이 만든 클래스로 비교정렬 할 때는 이리 씀
															//기존에 있던 클래스라면 return first - second;
			}	
		};
		list.sort(comp);
		System.out.println(list);
	}
	

}
