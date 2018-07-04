package pack001;

public class Main {
	public static void main(String[] args) {
		p01 emp1 = new p01(0);		//moni 생성 후에
		//객체 내용을 학인하고자 하면 System.out.println 메소드에 객체의 이름만 대입해도 됨
		System.out.println(emp1);
		p01 emp2 = new p01(0);
		System.out.println(emp2);
		
		pp01 man1 = new pp01();
		System.out.println(man1);
	}
}

