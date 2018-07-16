package p01;

public class TradeMain {

	public static void main(String[] args) {
		sharedata trade = new sharedata();
		Cuns t1 = new Cuns(trade);
		t1.start();	
		Prod t0 = new Prod(trade);
		t0.start();
		


	}

}
