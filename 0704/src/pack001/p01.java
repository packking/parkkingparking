package pack001;

public class p01 {
	//번호,이름 저장

//	private int num;
//	private String name;
	
	//상속받은 곳에서도 사용 가능하게 private -> protected로
	protected int num;
	protected String name;
	
	//num의 값을 일련번호로 만들기 위한 공유 변수 ( Static으로)
	private static int moni;			//0으로 되있음
	
	//생성자
	public p01(int n) {
		//System.out.println("********************");
		//일련번호 만들기
		moni=moni+1;
		num=moni;		//초기화 해서 번호부여하기 위해 만듬
	}
	//접근자 메소드들
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//값 확인 용이
	@Override
	public String toString() {
		return "p01 [num=" + num + ", name=" + name + "]";
	}

}
