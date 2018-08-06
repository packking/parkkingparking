package rambdatest01;
public class RunnableImpl implements Runnable {

	@Override
	public void run() {			//1초마다 1부터 10까지 출력
		int a = 1;
		while(a<=10) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
			System.out.println("a : "+a);
			a=a+1;
		}

	}

}
