package thread;

import java.util.Random;

public class Horse extends Thread {
	//이 클래스로 부터 만들어진 모든 인스턴스가 공유
	private static int rank;
	public void run() {
		//스레드 이름 출력
		System.out.println(getName() + " 출발");
		
		//현재 위치를 저장할 변수
		int pos = 0;
		//랜덤한 값을 가져오기 위한 변수
		Random r = new Random();
		while(true) {
			try {
				Thread.sleep(1000);
				pos = pos + r.nextInt(10);
				if(pos > 100) {
					break;
				}
				System.out.println(getName() + ":" + pos);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		rank = rank + 1;
		System.out.println(getName() + " 골인");
		System.out.println(getName() + "  "+rank + "등");
	}
}