package pack01;

import java.util.Scanner;

public class test01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int gg = 0; gg < 1; gg++) {		//잘못 입력했을 때 다시 입력하는 것을 위한 반복문
			try {
				System.out.print("줄 수 입력 : ");
				int line = scan.nextInt();
				if (line <= 1) {	//1 이하는 출력 안하니 다시 입력하게 끔
					System.err.println("1보다 큰 수를 입력해주세요 ");
					gg = gg - 1;	//다시 입력하게끔 횟수역행
					continue;
				} else {
					test01 triangle = new test01();
					triangle.drawTriangle(line);
				}
			} catch (Exception e) {	//문자입력에 관한 예외처리
				System.err.println("문자를 입력하셨습니다!!");
				System.err.println("1보다 큰 수를 입력해주세요 ");
				scan.next();		//이 뒤의 입력작업이 없을 때 이 구문을 쓰지 않으면 무한루프에 빠지기에 이를 방지한 구문
				gg = gg - 1;	 //다시 입력하게끔 횟수역행
			}
		}

	}
	void drawTriangle(int lineNumber) {	//삼각형 제작

		int a, x = 0, y = 0, cnt = 0;
		int r = lineNumber;
		int n = r * ((r * 2) - 1); // ex 7입력 = 7*13
		int mid = r;	//컬럼의 중심
		int c = mid, d = mid;

		for (a = 1; a <= n; a++) {	
			if (cnt > (lineNumber - 2) && a % ((r * 2) - 1) > (mid - cnt) && a % ((r * 2) - 1) <= d
					|| a == (mid - (cnt + 1)) + (lineNumber * ((r * 2) - 1))) {
				// 밑바닥 찍기 a==(mid-(cnt+1))+(lineNumber*((r*2)-1))를 찍지 않으면 밑의 조건문과 중복됨-배열과 달리 충돌되면 중복장소 출력 제대로 안됨
				System.out.print(y);
				y = y + 1;
				if (y > 9) {		//출력문이 9가 넘어가면 0으로 초기화
					y = 0;
				}
			}
			else if ((a % ((r * 2) - 1)) == c || (a % ((r * 2) - 1)) == d) {
				System.out.print(x);
				x = x + 1;
				if (x > 9) {	//출력문이 9가 넘어가면 0으로 초기화
					x = 0;
				}
			} // 여기 조건문에 || a == (mid - (cnt + 1)) + (lineNumber * ((r*2)-1)))를 찍으면 밑바닥,동남사이드의 중복꼭지점 위치에 이쪽 결과물 나옴
			else if (c < (a % ((r * 2) - 1)) && d > (a % ((r * 2) - 1))) {// 혹시 모를 삼각형 테두리의 내부 변환
				System.out.print("*");
			} 
			else {
				System.out.print(" ");
			}
			if (a % ((r * 2) - 1) == 0) {// ((라인수 *2)-1)배수씩 줄내림 + 사이드 벌리기
				System.out.println("");
				if (cnt >= 0) {
					c = (mid - 1) - (cnt); // 서남방향 사이드
					d = (mid + 1) + (cnt); // 동남방향 사이드
				}
				cnt = cnt + 1;
			}
		}
	}
}