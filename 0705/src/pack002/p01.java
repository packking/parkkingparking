package pack002;

public class p01 {
	class Inner{
		
	}
	//static inner class : 내부 클래스 안에 스태틱 맴버가 있으면 일반 이너클래스는 에러발생  이 때 클래스 앞에 스태틱 붙이면 됨
	/*
	 static class Inner1{
	 	//static int a;		//클래스에 스태틱을 선언 안하고 내부의 변수에 스태틱을 먼저 선언하면 에러
	 	int a;
	 }
	 */
	//local inner class : 메소드 내부에 생성하는 클래스
	//메소드가 호출되서 실행될 때 만들어졌다가 없어지는 클래스
	//클래스가 메소드를 호출할 대만 존재하기 때문에 메모리 효율을 높일 수도 있음
	public void sample() {
		class inner2{
			
		}
	}
	
}

/*class Foreigen{
//Inner inner = new Inner(); //Inner는 testing 내부에서만 사용 가능
}*/