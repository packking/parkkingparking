package pack003;
//2개의 클래스의 상위클래스가 되는 클래스 생성

//하나의 변수를 가지고 2개의 인스턴스를 전부 대입받을 수는 있지만 메소드 호출은 불가
//변수는 오버라이딩 된 메소드만 하위 클래스의 것을 호출할 수 있기 때문입니다.

//오버아리딩을 만들어주기 위해서는 p01 클래스의 atk() 추가
public class p01 {
	//오버라이딩 관계를 만들기 위한 메소드
	public void atk() {
		System.out.println("공격을 하겠습니다");
	}
	
//이렇게 제작하면 Main을 제외한 클래스들은 복잡해지지만, Main 클래스는 간결해짐 -> 이는 유저가 사용하는 클래스이며, 나머지 클래스는 보조적인 역할을 수행하는 클래스
//Main이 간결해지면 유저는 편리해지고 개발자는 피곤해집니다.
}
