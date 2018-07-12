package etc;

import java.util.StringTokenizer;

public class StringTokenMain {

	public static void main(String[] args) {
		String msg = "나는 중학교때까지 야구 선수 였습니다.";
		
		//msg를 공백단위로 분할 해서 출력
		//1.split 메소드 이용
		String [] ar = msg.split(" ");
		for(String token : ar) {
			System.out.println(token);
		}
		System.out.println("================");
		
		StringTokenizer st = new StringTokenizer(msg, " ");
		while(st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}
		String data = "90.30.20.60";
		//data를 , 단위로 분할해서 합계를 구하기
		String [] tokens = data.split("\\.");
		int sum = 0;
		for(String token : tokens) {
			//잘라진 토큰을 정수로 변환해서 더하기
			sum = sum + Integer.parseInt(token);
		}
		System.out.println("합계:" + sum);

	}
}