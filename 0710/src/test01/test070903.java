package test01;

public class test070903 {

		public static void main(String[] args) {

			int a = 0, b = 0, c = 0, v = 0;
			int[][] ar = new int[6][11];
			String[][] vr = new String[6][11];	//공백배경을 깔아줄 배경
			int d = 5;
			int e = 5;

			for (a = 0; a < 6; a++) {	//잉여공간 공백으로 만들기 위한 밑작업
				for (b = 0; b < 11; b++) {
					ar[a][b] = 77;	// 모든 배열에 77 주입
				}
			}

			for (a = 0; a < 6; a++) {			//필요한 공간에다가만 새로운 값 갱신
				for (b = d; b <= e; b++) {

					if (b == d || b == e) {		//기둥에 값 입력

						ar[a][b] = c;
						c = c + 1;
					}

					if (a == 5 && b >= 1) {		//밑 바닥에 값 입력
						ar[a][b] = v;
						v = v + 1;
					}

					d = 4 - a;
					e = 5 + a;
				}
			}

			for (a = 0; a < 6; a++) {		
				for (b = 0; b < 11; b++) {

					if (ar[a][b] == 77) {
						(vr[a][b]) = "  ";		//갱신하지 않은.. 배열 내부의 값이 77인 쓰지 않는 공간들 공백으로 변환
						System.out.printf("%3s",vr[a][b]);
					} else {
						System.out.printf("%3d",ar[a][b]);
					}
				}

				System.out.println("");
			}

		}
	}