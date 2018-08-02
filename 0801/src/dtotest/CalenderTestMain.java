package dtotest;

import java.util.*;

public class CalenderTestMain {
	//년도와 월 을 입력받아서 해당 월의 달력찍기
	public static void main(String[] args) {
		//처리 2차원배열 -> 2018/8/1 요일? -> 1년 1월 1일부터 몇 번째 날
		//2년 2월 1일 365+31 -> 3년 3월 1일 (365+365)(31+28)
		
		//1년도와 월 입력받기
		Scanner ss = new Scanner(System.in);
		System.out.print("원하시는 연도를 입력해주세요 : ");
		int y = ss.nextInt();
		System.out.print("원하시는 월 을 입력해주세요 : ");
		int m = ss.nextInt();
		ss.close();
		
		int cnt=0;		//지나온 일 수를 저장하기 위한 변수
		int a=1;//1-해당년도 이전까지의 지나온 날수
		
		while(a<y) {	//연 별당 일수 계산 목적	//0001년부터 입력한 년도까지의 일수 계산
			if(a%4==0 && a%100!=0 || a%400==0) {	//윤년
				cnt=cnt+366;		//윤년이면 366일이기에
			}
			else{cnt=cnt+365;}		//아니면 365일
			a=a+1;	//년도 증가용
		}
		
		//이전 달 까지의 날수 더하기		//위에 계산했던 년도까지의 일수에 입력한 달 단위까지 계산
		//ex) 2018 08 => 2018/07/31일까지의 일수를 합산
		//이걸 구하는 이유는 달력에 어디 몇 째주 무슨 요일에 해당 달이 시작하는 지를 나타내기 위해서
		int [] mr = {0,31,28,31,30,31,30,31,31,30,31,30,31}; //0은 1부터 사용하려고
		if(y%4==0 && y%100!=0 || y%400==0) { mr[2]=29; }//윤년이면 28일을 29일로
		a=1;	//01월부터  입력한 달까지의 일수 계산	ex)2월 입력했으면 31+28(윤년x) 라는 방식으로
		while(a<m) {
			cnt=cnt+mr[a];	//입력한 년도를  일수로 환산한 카운트에서 추가로 월까지 계산
			a=a+1;	//월  증가용
		}
		System.out.println("일주일 중에서 "+((cnt%7)+2)+"번째 요일에 해당 달의 첫 날 시작");
		
		int [][] cal = new int[6][7];	//달력 틀
		int day=1;		//1일~월막일까지의 출력을 위한 수
		int week = cnt%7;	//몇 주 째에 1일이 시작하는 지
		while(day<=mr[m]) {		//1일~월 말 일까지 출력을 위한 반복문
			int x = week + day;	//기본적으로 0부터 시작임
			cal[x/7][x%7]=day;	//배열 투입 완료
			day++;
		}
		//배열에 투입된 데이터 출력
		for(int [] ar : cal) {
			for(int t : ar) {
				if(t==0) {
					System.out.print("    ");
				}
				else {System.out.printf("%4d",t);
			}
		}
			System.out.println();
		}

	}

}
