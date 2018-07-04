package pack003;

public class Main {

	public static void main(String[] args) {
		// 2개의 클래스의 공격하는 메소드 호출
		pp01 attk = new pp01();
		attk.atk();
		pp02 def = new pp02();
		def.atk();
		// pp01,pp02는 아무런 관계가 없어서 두 개의 변수를 만들어서 ㅁ소드를 호출
		//상위 클래스 타입의 변수에 하위 클래스 타입의 인스턴스 주소를 대입할 수 있는 문법을 아용하면 하나의 변수에 개의 클래스의 인스턴스 주소를 대입할 수 있습니다.

	}

}
