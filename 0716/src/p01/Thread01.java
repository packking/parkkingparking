package p01;

public class Thread01 extends Thread{
	private bankbook bank;
	private String name;
	
	//생성자에서 bankbook, 문자열에서 1개를 대입받기
	public Thread01(bankbook bank, String name) {
		this.bank = bank;
		this.name = name;
	}
	
	//스레드로 동작할 메소드
	public void run() {
		//bank의 메서드 3번 호출
		for(int a=0;a<3;a++) {
			bank.bankjob(name);
		}
	}
}
