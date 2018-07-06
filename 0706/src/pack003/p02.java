package pack003;

public class p02 {
	public static void main(String[] args) {
			//java.lang.Tread 라는 클래스에는 sleep 이라는 메소드가 있는데, 이 메소드는 매개변수로 대입된 만큼 실행을 중지시키는 역할을 합니다
			//이 메소드를 이용해서 1~10 까지 출력
//			for(int a=1; a<=10; a++) {
//				System.out.println(a);
//				try {
//					Thread.sleep(1000);	//Interrupted예외를 처리해야하 사용 가능
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		for(int a = 0;;a++) {		//sleep을 이용한 0,1,2, 무한반복
//
//			System.out.println("image."+a+".png");
//			if(a==2) { a=-1;}		
//			try {
//
//				Thread.sleep(1000);	//Interrupted예외를 처리해야하 사용 가능
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
			
		//김기태,이종범,최향남,이대진을 번갈아가면서 출력
		String[] arr = { "김기태", "이종범", "최향남", "이대진" };
		int size = arr.length;
		int a = 0;
		try {		//예외처리는 되도록이면 반복문 밖에서 ->안그러면 메모리 낭비함
			while (true) {
				System.out.println(arr[a % size]);
				a = a + 1;
				// try {
				//
				// Thread.sleep(1000); // Interrupted예외를 처리해야하 사용 가능
				// } catch (InterruptedException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }

				Thread.sleep(1000); // Interrupted예외를 처리해야하 사용 가능

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	}
