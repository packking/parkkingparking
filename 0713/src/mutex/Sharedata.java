package mutex;
import java.util.ArrayList;


//공유자원을 가진 클래스
public class Sharedata {
	//저장공간 생성
	public static ArrayList<Character> list = new ArrayList<>();
	
	//데이터를 저장하는 메소드
	public synchronized void save(char ch) {
		if(list.size() == 1) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		list.add(ch);
		System.out.println(ch +"를 저장했습니다");
		//전체알람
		notify();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//list에서 하나씩 꺼내는 걸 출력하는 메소드
	public synchronized void get() {
		if(list.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		char ch = list.remove(0);
		System.out.println(ch + "를 소비했습니다.");
		notifyAll();
	}
	
}
