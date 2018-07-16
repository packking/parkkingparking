package p01;

public class Main {

	public static void main(String[] args) {
		bankbook bank = new bankbook();
		//스레드 인스턴스 생성
		Thread01 atm = new Thread01(bank,"ATM");	//임계영역 관련 문제를 해결 안하면 이 작업과 아래의 작업이 동시 수행함	- 잔액이 1000씩 빠져야하는데 동시작업으로 인해 2000빠지는 경우
		atm.start();									//공유자원 클래스에서의 동기(synchronized)작업 - synchronized(this){내용}-기본적으로 자기자원 사용으로 this씀
		Thread01 internetbank = new Thread01(bank,"InternetBanking");
		internetbank.start();
		
	}

}
