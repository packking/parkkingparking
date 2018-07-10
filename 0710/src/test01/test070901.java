package test01;

import java.util.Scanner;

public class test070901 {

	public static void main(String[] args) {
		//금액 입력 -> 오만원,만원 지폐를 몇 장 줘야하는 지 계산하는 프로그램
		int a10000=0,a50000=0,na;
		Scanner monny = new Scanner(System.in);
		System.out.println("거래하실 금액을 입력해주세요 : ");
		int aa=monny.nextInt();
		monny.close();
		a50000=aa/50000;
		na=aa%50000;
		a10000=na/10000;
		
		
		System.out.println("거스름 돈으로 5만원짜리 "+a50000+"장, 만원짜리 "+a10000+"장 외 입니다.");
	}

}
