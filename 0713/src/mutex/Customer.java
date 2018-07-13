package mutex;

import java.util.ArrayList;

public class Customer extends Thread {
	private Sharedata data;
	
	public Customer(Sharedata data) {
		this.data = data;
	}
	//스레드로 수행할 내용을 가지는 메소드
	public void run() {
		for(int a=0;a<26;a++) {
		data.get();
		}
	}
}
