package rambdatest01;


interface Tester{
	public void method(int x);
}
interface Vega{
	public int add(int x,int y);
}

public class RambdaMain {

	public static void main(String[] args) {
		// 위와 같은 인터페이스 Tester를 구현해서 사용해야하는 경우
		//Tester a = (x)->{
//		Tester a = x->{			// 매개변수가 1개이니 ( ) 생략 가능 
//			System.out.println("x : "+x);
//		};
//		a.method(10);
		Vega vega = (x,y)->{	//리턴 타입이 있는 메소드일 때는 메소드 내에 있는 타입에 해당하는 데이터만 리턴함
			return x+y;
		};
		System.out.println(vega.add(101, 208));
	}

}
