package p01;

public class Prod extends Thread {
	private sharedata store;

	
	//생성자에서 sharedata
	public Prod(sharedata store) {
		this.store = store;		//this.클래스의 인스턴스 주소 ->지역변수와 인스턴스 변수의 구분, 자기 자신을 나타내려 할 때			
								//공용으로 사용하기 위해서 this 이용해서 생성
	}	
	
	//스레드로 동작할 메소드
	public void run() {
		//sharedata의 메서드 5번 호출
		for(int a=0;a<5;a++) {
			store.add();
		}
	}
}
