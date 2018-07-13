package mutex;

public class SyncMain {
	public static void main (String [] args) {
		Sharedata data = new Sharedata();
		
		Productor p = new Productor(data);
		Customer c = new Customer(data);
		
		p.start();
		c.start();
	}
}	
