package rambdatest01;
public class Main {

	public static void main(String[] args) {
		// 1. RunnableImpl 이라는 별도의 클래스를 만들어서 스레드 사용 //인스턴스 여러 개 만들어서 사용할 때 -> 재활용해서 쓰는
		// 개념
		// RunnableImpl r = new RunnableImpl();
		// Thread trd = new Thread(r);
		// trd.start();
		//
		// RunnableImpl r2 = new RunnableImpl();
		// Thread trd2 = new Thread(r2);
		// trd2.start();

		// 2. 익명클래스를 써서 스레드 생성		//클래스 선언 안해서 메모리 차지는 덜하지만 
										//위의 방법이랑 다르게 1개 정도만 사용할 때에 사용하는 방식
//		Runnable r = new Runnable() {	//익명클래스 사용하려면 추상클래스나 인터페이스 필수
//			@Override
//			public void run() {
//				int a = 1;
//				while (a <= 10) {
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						System.err.println(e.getMessage());
//						e.printStackTrace();
//					}
//					System.out.println("a : " + a);
//					a = a + 1;
//				}
//			}
//		};
//		 Thread trd = new Thread(r);
//		 trd.start();
		
		//3.람다식					//추상메소드가 1개일 때나 상속받고자 하는 인터페이스에 메소드가 1개만 있을 때만 가능
		Runnable r = ()-> {			//메모리에 따로 상주시키지 않기 위한 방식
				int a = 1;
				while (a <= 10) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.err.println(e.getMessage());
						e.printStackTrace();
					}
					System.out.println("a : " + a);
					a = a + 1;
					if(a==11) {System.out.println("작업이 완료됬습니다!");}
				}
		};
		 Thread trd = new Thread(r);
		 trd.start();
		 
		 
	}

}
