package pack002;
//스레드를 상속받은 클래스 
public class p02  extends Thread {
	//오버라이딩 한 메소드라는 것을 나타내는 이노테이션
	public void sample() {
		try {
			for(int a=0;a<10;a++) {
				System.out.println(a);
				Thread.sleep(1000);
			}
		}
		catch(Exception e) {}
			
	}	
}

