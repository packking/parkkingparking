package singletonTest;
public class TestClass {
	//외부애서 생성 못하도록 private
	private TestClass(){}
	
	//1개만 만들어서 리턴해주기 위한 스태틱 변수 선언
	private static TestClass obj;
	
	//객체가 없으면 만들어서 리턴하고 있으면 그냥 리턴하는 스태틱메소드 생성
	public static TestClass getInstance() {
		if(obj==null) {
			obj=new  TestClass();
		}
		return obj;
	}
}
