package mutex;

public class MutexMain1 {

	public static void main(String[] args) {
		Mutex mutex = new Mutex();
		Thread th1 = new Thread(mutex);
		th1.start();
		Thread th2 = new Thread(mutex);
		th2.start();
		
		//25초 후에 mutex의 result 값 확인
		try {
			Thread.sleep(25000);
			System.out.println(mutex.getResult());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}