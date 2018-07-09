package p01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// //value형 변수 생성
		// int a =10;
		// //value형 변수 데이터 대입
		// int x=a; //a에 저장된 10이 x에 저장됨
		// x=20;
		//
		// System.out.println(a);
		//
		// //reference형 변수 생성
		// int ar[] = {10,20,30};
		// //reference형 변수 데이터 복사 - 주소가 복사됨
		// int br[]=ar;
		// //복사된 주소의 0번 데이터를 100으로 변경
		// br[0]=100;
		// System.out.println(ar[0]);
		//
		//
		// //참조형을 복사해 줄 때 실제 데이터를 복사해주기에 배열을 복사하기 위해서는 새로운 공간을 생성해야함
		// int cr[]= new int[ar.length];
		// //내부 데이터 복사
		// for(int b =0;b<ar.length;b++) {
		// cr[b]=ar[b];
		// }
		// cr[0]=500;
		// //이번에는 데이터를 복사해주었기에 기존 쪽에 영향을 주지 못함
		// System.out.println(ar[0]); //br에 영향받았던 100 출력

		s01 user = new s01();
		user.setNum(1);
		user.setName("고길동");
		String[] hobi = { "명상", "독서" };
		user.setHob(hobi);
		// toString 을 호출해서 내부 내용 확인
		// System.out.println(user);

		s01 user2 = user;
		user2.setNum(2);
		System.out.println(user);// toString(호출) ->클래스이름 &해시코드

		s01 user3 = user.clone();
		user3.setNum(3);
		user3.setName("이민혁");
		user3.getHobi()[0] = "연기";
		System.out.println(user);
		System.out.println(user3);

		Integer aa = new Integer(10);
		System.out.println(aa);

		aa = 20;
		System.out.println(aa);

		aa = Integer.parseInt("700");
		System.out.println(aa);
		try {
			aa = Integer.parseInt("10k");
			System.out.println(aa);
		} catch (Exception e) {
			System.err.println("잘못된 값을 출력하셨습니다");
		}
		
		//정수만 입력 받고, 이외의 것을 입력하면 정수를 입력받을 때까지 무한반복
//		int kk=0;	//무언가가 대입되는 변수는 초기값 필수
//		Scanner sc=new Scanner(System.in);
//		while(true) {
//			System.out.print("정수 입력 : ");
//			String temp = sc.nextLine();
//			try {
//				kk=Integer.parseInt(temp);	//정수 이외의 것을 입력받으면 예외되기에 예외처리 해줘야함
//			break;	//정상적으로 정수를 입력받으면 반복 종료  - 없으면  System.out.println(kk); 쪽에 에러
//			}catch(Exception e) {
//				System.out.println("정수를 입력해주세요");//정수 이외의 것을 입력받으면 다음에는 정수를 입력하게끔 안내하는 출력문
//			}
//		}
//		System.out.println(kk);
//		sc.close();//안쓰면 위에 java.util.Scanner 작성해야함
		
		//1~45까지 중복되지 않는 6개의 정수 저장
		Scanner sc=new Scanner(System.in);	//참조형은 기본값이 0이기에 입력받지 않았으면 0으로 출력
		int ar[] = new int[6];			//데이터 저장받을 배열
		int size = ar.length;			//인덱스 - 배열길이
		int br[] = new int[size];  		//데이터 개수 저장받을 배열 
		int b;
//		for(int a=0;a<size;a++) {		//배열의 모든 데이터 출력(for)
//			System.out.print(ar[a]);
//		}
//		int a = 0;
//		while(a<size) {					//배열의 모든 데이터 출력(while)
//			System.out.print(ar[a]);
//			a++;
//		}
		
		for (int a = 0; a < size; a++) {
			try {
				System.out.print("정수 입력 : "); // 문자입력 시에 예외가 되므로 그를 위한 예외처리 1
				String ak = sc.nextLine();

				ar[a] = Integer.parseInt(ak);
//				for (b = 0; b < a; b++) {// 이전에 입력했던 값 중에서 중복이 있는지 확인이므로 맨 첫번째~a횟수 까지 검사
//					if (ar[a] == ar[b]) {
//						System.out.println("중복된 값이 있사오니 다시 입력해주세요.");
//						a = a - 1;
//					}
//				}
				for (b = 0; b < a; b++) {// 중복 입력하면 반복문 종료		여기다 b를 새로 선언했다면 아랫쪽에서도 새로 b를 선언해야하기에 미리 b를 선언
				if (ar[a] == ar[b]) {
						break;
				}	
			}
			//이전 데이터와 방금 입력된 데이터가 동일하면 횟수 복구
			if(b != a) {
				System.out.println("중복된 값이 있사오니 다시 입력해주세요.");
				a = a - 1;
				continue;
			}
				if (ar[a] > 45 || ar[a] < 1) {
					System.out.println("1~45 정수를 입력해주세요");
					a = a - 1;
				}
			} catch (Exception e) { // 예외처리 2
				System.out.println("1~45 정수를 입력해주세요");
				a = a - 1; // 증가했던 값을 다시 되돌리면 횟수 원상복구
			}
		}
		for(int a=0;a<size;a++) {	//출력

		System.out.printf("%3d",ar[a]);
		}
	}

}
