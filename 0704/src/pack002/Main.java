package pack002;

public class Main {

	public static void main(String[] args) {
//		// p01슈퍼 클래스의 인스턴스를 생성
//		p01 base= new p01();
//		//	pp01 슈퍼클래스의 인스턴스를 생성
//		pp01 drive = new pp01();
//		
//		//상위 클래스의 타입의 변수에 하위 클래스 타입의 인스턴스 주소 대입 가능  -  자바는 객체지향 언어기에 가능하며, 일반적으로는 같은 자료형만 가능
//		p01 ob1 = new pp01();
//		
//		//반대로 하위 변수에 상위 인스턴스 주소 대입은 강제 형 변환을 해야만 가능 ->에러발생
//		//Exception in thread "main" java.lang.ClassCastException: pack002.p01 cannot be cast to pack002.pp01
//		//at pack002.Main.main(Main.java:15)
//		pp01 ob2 = (pp01)(new p01());
		
		//상위 클래스 타입의 변수에 하위 클래스 타입의 주소를 대입할 수 있습니다.			-  다형성 관련
		//sto는 기본적으로 p01 것만 호출할 수 있음. ->오버라이딩 됬으면 하위 클래스도 가능
		p01 sto = new p01();
		sto.dis();
		//오버라이딩 된 메소드는 변수를 선언할 때 사용한 자료형이 아니라 인스턴스를 만들어서 대입할 때 사용한 자료형의 것을 호출함.
		sto = new pp01();
		sto.dis();		//pp01의 dis()를 호출
	}

}
