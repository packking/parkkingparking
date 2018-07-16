package Window;

import java.awt.Button;
import java.awt.Color;

public class ColorThread extends Thread {
	private Button bt;
	public ColorThread(Button bt) {
		this.bt  = bt;
	}
	
	public void run() {
		//색상 배열 생성
		Color [] iro = {Color.red,Color.black,Color.green };
	
	int a=0;
	while(true) {
		try {
			
			Thread.sleep(1000);
			a=a+1;
			bt.setBackground(iro[a%iro.length]);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}
}
