package pack01;

import java.util.*;

public class Main2 {

	public static void main(String[] args) {
		// 정수를 저장하는 리스트들 생성 -> 중간에 데이터 10만개를 삽입하는데 걸리는 시간 측정
		ArrayList<Integer> a1 = new ArrayList<>();
		LinkedList<Integer>l1= new LinkedList<>();

		a1.add(1);
		a1.add(3);
		a1.add(4);
		
		l1.add(1);
		l1.add(3);
		l1.add(4);
		
		//a1에 10만개 를 중간에 넣고 시간측정
		long st = System.currentTimeMillis();
		int a=0;
		for(;a<1000000;a++) {
			//1번 자리에 2를 추가
			a1.add(1,2);
		}
		long end = System.currentTimeMillis();
		System.out.println("a1 : "+(end-st));
		
		//a1에 10만개 를 중간에 넣고 시간측정
		st = System.currentTimeMillis();

		for(;a<1000000;a++) {
			//1번 자리에 2를 추가
			l1.add(1,2);
		}
		 end = System.currentTimeMillis();
		System.out.println("l1 : "+(end-st));// 걸린 시간 = 작업종료시간 + 작업 시작시간
		
		//읽는 시간
		st = System.currentTimeMillis();

		for(;a<1000000;a++) {
			//1번 자리에 2를 추가
			a1.get(a);
		}
		end = System.currentTimeMillis();
		System.out.println("a1 : "+(end-st));
		
		st = System.currentTimeMillis();

		for(;a<1000000;a++) {
			//1번 자리에 2를 추가
			l1.get(a);
		}
		end = System.currentTimeMillis();
		System.out.println("l1 : "+(end-st));
		
	}

}
