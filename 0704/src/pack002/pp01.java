package pack002;
//p01 클래스를 상속받는  pp01클래스
public class pp01 extends p01 {
	//p01의 dis메소드 오버라이딩
	//아래 어노테이션이 에러 발생이 안됬으면 제대로 오버라이딩 됬다는 걸 알려줌
	public void dis() {
		System.out.println("Oh~!!!! ");
	}
	public void ass() {
		System.out.println("하위 클래스애서 만든 메소드");
	}
}
