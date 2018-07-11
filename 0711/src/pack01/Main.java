package pack01;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//문자열 저장할 수 있는 배열목록
		ArrayList<String> al = new ArrayList<>();
		al.add("피카츄");
		al.add("라이츄");
		al.add("파이리");
		al.add("꼬부기");
		al.add("또가스");
		//데이터 개수
		System.out.println("데이터 개수 : "+al.size());
		//전체 데이터 출력
		for(String m : al) {	//for-each - 순차출력,역행 불능
			System.out.printf("%s ",m);
		}
		System.out.println("");	//아래로
		//2번째 자료 출력
		System.out.println("2번째 자료 : "+al.get(1));

	}

}
