package pack002;

public class Main {

	public static void main(String[] args) {
		Thread obj = new p02();	
		obj.start();
		
		//스레드 클래스의 Anonnymous 만들기		//대신 두 번 이상 제작 불가 - 제작 불가 -> 1회성
		Thread aa = new p02() {
			public void run() {
				try {
					for(int b=10;b<20;b++) {
						System.out.println(b);
						Thread.sleep(1000);	// 1000당 1초
					}
				}
				catch(Exception e) {}
			}
		};
		aa.start();

	}

}
