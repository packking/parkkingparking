package Window;

import java.awt.Button;

public class TextThread01 extends Thread {
	private Button bt;
	public TextThread01(Button bt) {
		this.bt=bt;
	}
	
	public void run() {
		String [] ar = {"aa","bb","cc","dd","ee","ff"};
		int a=0;
		while(true) {
			try {
				//
				
				Thread.sleep(1000);
				a=a+1;
				bt.setLabel(ar[a%ar.length]);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
