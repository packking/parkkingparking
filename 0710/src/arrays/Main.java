package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 인스턴스 배열 만들기 - 5개 저장할 수 있는 배열을 생성
		// 아직은 모두 null
		book[] bkks = new book[5];
		// 인스턴스 생성
		bkks[0] = new book();
		// 값을 채웁니다.
		bkks[0].setTitle("삼국지");
		bkks[0].setAuthor("나관중");
		bkks[0].setPubdate("2017-08-11");
		bkks[0].setPrice(30000);

		// 인스턴스 생성
		bkks[1] = new book();
		// 값을 채웁니다.
		bkks[1].setTitle("춘추");
		bkks[1].setAuthor("공자");
		bkks[1].setPubdate("2016-07-11");
		bkks[1].setPrice(20000);
		// 인스턴스 생성
		bkks[2] = new book();
		// 값을 채웁니다.
		bkks[2].setTitle("열혈강의 C");
		bkks[2].setAuthor("윤성우");
		bkks[2].setPubdate("2015-07-17");
		bkks[2].setPrice(33000);
		// 인스턴스 생성
		bkks[3] = new book();
		// 값을 채웁니다.
		bkks[3].setTitle("안드로이드 완전 정복");
		bkks[3].setAuthor("김상형");
		bkks[3].setPubdate("2013-02-11");
		bkks[3].setPrice(60000);

		// 인스턴스 생성
		bkks[4] = new book();
		// 값을 채웁니다.
		bkks[4].setTitle("Swift 4");
		bkks[4].setAuthor("김근영");
		bkks[4].setPubdate("2018-03-11");
		bkks[4].setPrice(40000);
		
		//배열의 데이터를 정렬
		//기본적으로 정렬을 하려면 각 데이터의 크기를 비교할 수 있어야 합니다.
		//java에서 크기 비교를 하는 메소드는
		//Comparable 인터페이스의 compare 메소드 입니다.
		//직접 만든 클래스의 경우는 클래스에 Comparable 인터페이스를
		//implements 하던가 Comparator 인터페이스를 implements한
		//인스턴스를 같이 대입해야 합니다.
		
//		//Comparator 인터페이스를 implements 한 인스턴스 만들기
//		Comparator <book> comp = new Comparator() {
//			@Override
//			public int compare(Object o1, Object o2) {
//				//데이터 형 변환
//				book first = (book)o1;
//				book second = (book)o2;
////				//price을 이용해서 비교
////				return first.getPrice() - second.getPrice();
//				//title을 이용해서 비교
//				return first.getTitle().compareTo(second.getTitle());
//			}
//		};
//		Arrays.sort(bkks, comp);
//		
//		//배열의 데이터 전부 출력
//		for(book bkk : bkks) {
//			System.out.println(bkk);
//		}
		
		Scanner ss = new Scanner(System.in);
		while(true) {
			//비교할 Comparator
			Comparator <book> comparator = null;
			System.out.println("0 : 종료 , 1 : 제목으로 오름차순 , 2 : 제목으로 내림차순, 3 : 가격으로 오름차순, 4 : 저자로 내림차순");
			int menu = ss.nextInt();
			if(menu==0) {break;}
			else if(menu==1) {
				comparator = new Comparator() {
						@Override
						public int compare(Object o1, Object o2) {
							//데이터 형 변환
							book first = (book)o1;
							book second = (book)o2;
							//title을 이용해서 비교
							return first.getTitle().compareTo(second.getTitle());	//이걸로 오름차순,내림차순
					}
					
			};
			}
			else if(menu==2) {
				comparator = new Comparator() {
						@Override
						public int compare(Object o1, Object o2) {
							//데이터 형 변환
							book first = (book)o1;
							book second = (book)o2;
							//title을 이용해서 비교
							return second.getTitle().compareTo(first.getTitle());
					}
					
			};
			}
			else if(menu==3) {
				comparator = new Comparator() {
						@Override
						public int compare(Object o1, Object o2) {
							//데이터 형 변환
							book first = (book)o1;
							book second = (book)o2;
							//title을 이용해서 비교
							return first.getPrice() - second.getPrice();
					}
					
			};
			}
			else if(menu==4) {
				comparator = new Comparator() {
						@Override
						public int compare(Object o1, Object o2) {
							//데이터 형 변환
							book first = (book)o1;
							book second = (book)o2;
							//price을 이용해서 비교
							return second.getAuthor().compareTo(first.getAuthor());
					}
					
			};
			}
			Arrays.sort(bkks, comparator);
			
			//배열데이터 전부 출력
			for(book bkk : bkks) {
				System.out.println(bkk);
			}
			System.out.println("==============");
		}
		ss.close();

	}
}




