package thread;

public class ThreadMain1 {

	public static void main(String[] args) {
		//앞에서 만든 클래스의 인스턴스를 만들고 run 메소드를 호출
		/*
		ThreadEx1 th1 = new ThreadEx1();
		th1.run();
		ThreadEx1 th2 = new ThreadEx1();
		th2.run();
		*/
		
		
		//스레드로 실행
		ThreadEx1 th1 = new ThreadEx1();
		th1.setDaemon(true);
		th1.start();
		ThreadEx1 th2 = new ThreadEx1();
		th2.setDaemon(true);
		th2.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("메인 종료");
		
	}

}