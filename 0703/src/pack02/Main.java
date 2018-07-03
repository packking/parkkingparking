package pack02;

public class Main {

	public static void main(String[] args) {
		

		
		//p01 클래스의 인스턴스 생성
		p01 p3 = new p01();
		//p01 p1 = new p01();
		//p1.setName("Noname");
		System.out.println(p3.getName());
		//p01 p2 = new p01();
		p01 p4 = new p01();
		//p2.setName("Noname");
		System.out.println(p4.getName());
		
		p01 p5 = new p01("Park");
		System.out.println(p5.getName());	//Park 이 나오는 이유
											//p01()의 번지를 찍어줌
											//p5는. = p01클래스로 가서  public String getName(){}가고서  name 을 리턴해줌
											//이 때 스택이 만들어지며, 리턴해주는 name은 p5에 주어진 값인 "Park"  만약 값이 없었으면 일반생성자로 설정된 Noname으로 출력
											//this 쓰면 지역변수와 인스턴스변수와 동명일 경우에는 외부에 있는 것부터 사용하기 위해서
		
		String str = "Hello!!";
		int r = str.lastIndexOf("!");	//두개 모두 특정 문자열의 시작위치를 구하는 함수 입니다.
										//indexOf 는 앞에서 부터 찾고 lastIndexOf 는 뒤에서 찾는것이 차이점 입니다.
										//0부터 탐색하며, lastIndexOf는 역행탐색이므로 !가 2개 이며 마지막 것 먼저 탐색했기에 6
		System.out.println(r);
		
		r= str.length();			//길이		Hello!!라서 7개  길이는 1부터
		System.out.println(r);
		p5.pp7();		//this. 관련
		System.out.println("추");
	}

}
