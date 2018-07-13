package mutex;

import java.util.ArrayList;

public class Productor extends Thread{
	private Sharedata data ;
	
	//생성자
	public Productor(Sharedata data) {
		this.data = data;
	}

	//스레드로 동작할 메소드
	public void run() {
		for(int a=0;a<26;a++) {
			data.save((char)(65+a));
		}
	}
}
