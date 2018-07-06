package pack002;

public class Main {

	public static void main(String[] args) {
		// p01 클래스의 인스턴스를 생성해서 데이터 저장
		p01 car1 = new p01();
		car1.setModname("람보르기니");
		car1.setA(4000);
		car1.setPrice(35000);
		//toString을 호출
//		System.out.println(car1.toString());	//  p01에서 오버라이딩을 안했으면 pack002.p01@가상주소 출력함    아래도 동일함
//		System.out.println(car1);				//toString() 사용 목적은 디버깅 검사 빠르게 하기 위해서
		
		p01 car2 = new p01();
		car2.setModname("람보르기니");
		car2.setA(3000);
		car2.setPrice(2800);
		
		

		System.out.println(car1==car2);	
		System.out.println(car1.equals(car2));
	}

}
