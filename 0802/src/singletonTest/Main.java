package singletonTest;
public class Main {

	public static void main(String[] args) {
//		TestClass obj1 = new TestClass();	//생성자를 이용해서 객체 생성
//		TestClass obj2 = new TestClass();	//private 로 막아서 오류
		
		TestClass obj1 = TestClass.getInstance();
		TestClass obj2 = TestClass.getInstance();
		
		System.out.printf("%s,%s	\n",System.identityHashCode(obj1) , System.identityHashCode(obj2));
		//전자는 따로따로 쓰는 개념이고,   후자는 private static TestClass obj;로 인해 공유해서 사용하므로 동일해시코드 출력됨
		int a=10;	//10을 생성 후 그 주소값을 a에 대입
		int b=10;	//상수든 뭐든 동일자료 생성하면 같은 것 계속 쓰는 개념->그러기에 b에도 a와 같은 주소값이 대입되는 개념
		System.out.printf("%s,%s	\n",System.identityHashCode(a) , System.identityHashCode(b));	//10에 대한 해시코드가 나오기에 둘은 동일함
	}

}
