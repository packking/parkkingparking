package p00;
public class Thread01 extends Thread {
	public void run() {		//스레드로 동작하게 될 메소드
		//1초마다 Thread라는 글자를 10번씩 출력
		int a=0;
//		for(int a=0;a=10;a++) {}

		while(a<10) {
			
			System.out.println("Thread");
			try {
				Thread.sleep(1000);				//1초씩 대기
			} catch (InterruptedException e) {
				System.out.println("Thread 강제종료");		//스레드 강제종료 할 수 있도록
				return;									//예외가 발생하면 run 메소드 종료	//사실상 항상 있어야하는 return
//				System.out.println(e.getMessage());
//				e.printStackTrace();
			}
			a=a+1;
		}
	}
}
