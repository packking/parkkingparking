package practice;

public class Main {

	public static void main(String[] args) {
		Object  ob = new Object();
		//ob 인스턴스의 toString 결과 출력
		//직접 호출하거나 인스턴스 이름만 설정하나 결과는 같음
		System.out.println(ob.toString());
		System.out.println(ob);
		
		Integer a =100;
		//toString의 결과는 저장하고 있는 데이터인 100
		System.out.println(a.toString());
		System.out.println(a);
		
		//상위 클래스 타입의 참조형 변수에 하위 클래스 타입의 인스턴스 참조를 대입할 수 있음
		Object str = "Hello Java~!";
		//출력할 때는  형 변환 없이 사용해도 됨
		//toString()은 Object가 가지고 있으므로 호출할 수 있기 때문
		System.out.println(str);
		//Object 타입의 변수는 출력할 때를 제외하고는 아래처럼 원래의 자료형으로 강제 형 변환을 해야만 사용가능
		String prot = (String)str;
		for(int b=0;b<prot.length();b++) {
			
		}
	}

}
