package pack002;

public class p01 {
	//차의 모델명, 배기량, 가격을 저장할 변수
	private String modname;
	private int a;
	private int price;
	
	//인스턴스 변수를 사용하기 위한 접근자 메소드 - getter, setter  -> private 접근지정자이지만  데이터 공유를 위해 사용
	public String getModname() {
		return modname;
	}

	public void setModname(String modname) {
		this.modname = modname;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	//내부 데이터의 값을 빠르게 확인하기 위한 용도로 사용
	@Override
	public String toString() {
		return "p01 [modname=" + modname + ", a=" + a + ", price=" + price + "]";
	}
	//2개의 내용이 같은 지 비교하는 메소드
	public boolean equals(p01 other) {
		boolean rst = false;
		//호출하는 인스턴스의 modname, 매개변수 modname이 같으면 true를 리턴, 아니면 false를 리턴
		if(modname.equals(other.modname)) {
			rst = true;
		}
		return rst;
	}
	
}
