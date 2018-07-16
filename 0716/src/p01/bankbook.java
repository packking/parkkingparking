package p01;

public class bankbook {		//공유자원 클래스
	//잔액 저장할 변수
	private int ab=10000;
	
	//잔액을 변경하는 매소드
	public void bankjob(String aa) {
		//this - 자기 자신의 자원을 사용하는 경우		이 코드는 1번에 수행되도록 설정
		synchronized(this) {
		System.out.println(aa+ " 현재 잔고: "+ab);
		ab=ab-1000;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(aa+ " 작업 후의 잔고 : "+ab);
	}
	}
}
