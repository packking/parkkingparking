package p01;

public class sharedata {
	private int product;
	
	//재고 추가 메소드
	public synchronized void add() {			//싱크로나이즈드
		System.out.println(" 현재 재고: "+product);
//		if(product == 2) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		product=product+1;

		notify();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" 작업 후의 재고 : "+product);
	}
	public synchronized void get() {	//재고감소
		
		
		if(product<1) {		//notify(); 를 호출 할 때까지 대기
		try {
			System.out.println(" 현재 재고가 없으므로 대기. ");
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();		//인터럽트예외 발생했다는 메세지(알림)를 출력스택에 쌓음
		}
		}
		System.out.println(" 현재 재고: "+product+"이므로 구매시도");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		product=product-1;
		System.out.println(" 구매 후의 재고 : "+product);
		//notifyAll();	//add에 대기해야하는 기준이 있을 때 + 보다 먼저 실행되는 경우에 사용   	->일방통행식 거래가 아닌 양방향식 작업일 경우  //원하는 제품 없을 때 재고 들여놔달라는 요구 개념
	}
	
	
}
