package pack02;

public class p01 {
	static {	// 맨 처음에만 수행됨
		System.out.println("1회용");
	}
	
	{	//new p01 할 때마다 수행됨
		System.out.println("인스턴스 생성마다 수행");
	}
	
	
	//생성자
	public p01() {
		name="Noname";		//호출하는 것들에 이 결과를 출력
	}
	//생성자
	public p01(String arg) {	//String arg은 생성자 오버로딩 때문에 줌	//생성자 오버로딩은 동명칭의 메소드가 2개 이상 있는 경우
		name = arg;
	}
	
	//이름을 저장하기 위한 인스턴스 변수 선언
	private String name;
	//name의 접근자 메소드 getter, setter
	public String getName() {//getName(this )
		return name;
	}

	public void setName(String name) {//setName(p01 this, String name)
		this.name = name;
	}
	
	public void pp7() {
		String name = "지역변수 name";		//여기서는  이 값을
		//this.를 붙이면 지역변수애서 찾지 않고 인스턴스 변수에서 찾아옴
		System.out.println(name);
	}
	
}
