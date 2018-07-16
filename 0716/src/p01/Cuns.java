package p01;

public class Cuns extends Thread {
	private sharedata purchase;
	
	public Cuns(sharedata purchase) {
		this.purchase = purchase;
	}
	
	public void run() {
		for(int a=0;a<5;a++) {
			purchase.get();
		}
	}
}
