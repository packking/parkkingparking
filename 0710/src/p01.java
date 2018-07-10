import java.util.*;

public class p01 {

	public static void main(String[] args) {
		
		int a = 200;
		int b = 100;
		//a:200 b:100 형식의 문자열 만들기
		String str = String.format("a:%d b:%d", a, b);	//printf와는 다르게 출력이 아닌 리턴
		System.out.println(str);	//리턴하기에 이렇게 써줘야 출력됨
		
		
		
		
		String msg = "I like Java";
		//위의 문자열에서 java 포함여부 확인 - 대소문자 구분 없이
		int idx = msg.toLowerCase().indexOf("java".toLowerCase());	//대문자가 있을 수도 있기에 indexOf("java".toLowerCase()); 추가
		if(idx>=0) {
			System.out.println("java가 존재합니다");
		}
		else {
			System.out.println("java가 존재하지 않습니다");
		}
		//msg의 문자열을 공백 기준으로 분할해서 하나씩 출력
		String [] ar = msg.split(" "); 	//(" ") 로 공백을 기준잡음
		for(int aa=0;aa<ar.length;a++) {
			System.out.println(ar[aa]);
		}
		//msg의 3번째~7번째 글자까지 출력
		String sub = msg.substring(3,8);	//(시작,끝 직전)
		System.out.println(sub);
		
		ArrayList<Integer> arrr = new ArrayList<>();
		HashMap<String, String> hm =  new HashMap<>();

	}

}
