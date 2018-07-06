package pack003;

public class Main {

	public static void main(String[] args) {

//		System.exit(0);	// 프로그램 종료  - 0은 정상 종료 , 1~n은 문제관련
	try{		//예외발생 후에 중단하지 말고 다음 작업을  실행되도록
		int a = 10;
		int b = 0;
		int rst =  a/b; //예외 발생 - > 정수를 0으로 나누었기에
		System.out.println("결과 : " +rst);
	}catch(Exception e) {
		System.err.println("에러가 발생했으므로 현재 작업은 중단하고, 다음 작업으로 넘어가겠습니다.");
	}
		
		System.out.println("예외 발생 후 실행");
	}

}
