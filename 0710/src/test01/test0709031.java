package test01;

import java.util.Scanner;

public class test0709031 { // class test070903는 배열로 했기에 여기서는 유사결과를 배열없이
	public static void main(String[] args) {

		int gg;
		Scanner sc = new Scanner(System.in);

		for (gg = 0; gg < 4; gg = gg + 1) {
			try {
				int a; // 세로 6칸, 가로 11칸 이기에 6*11인 66
				//int ex = 0; 
				int x = 0, y = 0, cnt = 0;
				int mid = 6;
				int c = mid, d = mid;

				System.out.print("줄 수 입력 : ");
				int lineNumber = sc.nextInt();

				int r = lineNumber;
				int n = r * 11;

				if (r > 6 || r < 1) {
					System.out.println("1~6사이의 수를 입력해주세요 : ");
					gg = gg - 1;
					continue;
				}
				for (a = 1; a <= n; a++) {
					// ex = ex + 1; //줄띄움을 위한 카운트
					if (cnt > (lineNumber - 2) && a % 11 > (mid - cnt) && a % 11 <= d
							|| a == (mid - (cnt + 1)) + (lineNumber * 11)) {
						System.out.print(y);
						y = y + 1;
					}
					// 밑바닥 찍기 a==(mid-(cnt+1))+(lineNumber*11)를 찍지 않으면 밑의 조건문과 중복됨-배열과 달리 충돌되면 출력
					// 제대로 안됨
					else if ((a % 11) == c || (a % 11) == d) {
						System.out.print(x);
						x = x + 1;
					} // 여기 조건문에 || a == (mid - (cnt + 1)) + (lineNumber * 11))를 찍으면 이쪽 결과물 나옴
					else if (c < (a % 11) && d > (a % 11)) {
						System.out.print(" ");
					} // 삼각형 테두리의 내부 변환
					else {
						System.out.print(" ");
					}

					// if(ex%11==0) { //11배수씩 줄내림 + 사이드 벌리기
					if (a % 11 == 0) {
						System.out.println("");

						if (cnt >= 0) {
							c = (mid - 1) - (cnt);
							d = (mid + 1) + (cnt);
						}
						cnt = cnt + 1;
					}
				}

			} catch (Exception e) {
				sc.next();		//아래 새로운 입력작업이 없을 때 입력을 안해주면 무한루프
				System.out.println("숫자를 입력하지 않으셨습니다.");
				gg = gg - 1;
			}

			System.out.print("종료하실거면 y를 눌러주세요  ");
			String end = sc.next();
			if (end.equals("y") || end.equals("Y")) {
				break;
			}

		}

	}
}
