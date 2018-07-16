package p00;
public class Main {

	public static void main(String[] args) {
		//클래스의 run메소드 사용
		Thread01 aa = new Thread01();
		aa.setDaemon(true);		//데몬스레드 - 다른 스레드가 작업 중이 아니면 자동 종료 작업		//false를 쓰면 데몬스레드 아니라는 걸 명시
		//예상치 못한 강제종료 등으로 인한 데이터 저장 관련의 작업에 주로 사용
		aa.start();		//스레드 시작 방식
		
		try {
			Thread.sleep(2000);
			aa.interrupt(); 		// 	InterruptedException 을 발생시켜서 강제종료 유발
			Thread.sleep(3000);
			System.out.println("End");
//			System.exit(0);	//프로그램 종료				as
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
