package pack001;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//맴버 클래스의 인스턴스 생성 	--다른 영역에 필요한 반복작업을 원하는 상황에 불러서 쓰기 위해 사용
		p01 inf1= new p01();
//		inf1.id ="zxc123";
//		inf1.pw ="1234";
//		inf1.cname ="그아악";
//		inf1.age = 22;
//		inf1.gender ="남성";
//		inf1.pnum="010-0000-0000";
		
		//접근지정자로 호출로 인해 변경됨
//		inf1.setId ("zxc123");
//		inf1.setPw ("1234");
//		inf1.setCname ("그아악");
//		inf1.setAge  (22);
//		inf1.setGender ("남성");
//		inf1.setPnum("010-0000-0000");		
//		
		//자료 입력받아서...
		Scanner ss = new Scanner(System.in);
		
//		System.out.print("Id를 입력 : ");
//		String id = ss.nextLine() ;
//		System.out.print("Password를 입력 : ");
//		String pw = ss.nextLine();
//		System.out.print("캐릭터명칭을 입력 : ");
//		String cname = ss.nextLine();
//		System.out.print("나이를 입력 : ");
//		int age = ss.nextInt();
//		System.out.print("성별을 입력 : ");
//		String gender = ss.nextLine();
//		System.out.print("핸드폰 번호를 입력 : ");
//		String pnum = ss.nextLine();
//		ss.close();//입력 종료
		
		

//		System.out.println("ID : "+inf1.id+"\n"+"Password : " +inf1.pw+"\n"+"캐릭터명 : "+inf1.cname+"\n"+"나이 : "+inf1.age+"\n"+"성별 : "+inf1.gender+"\n"+
//		"전화번호 : "+inf1.pnum);
	//	inf1.pp();
		System.out.println(inf1);
		
		System.out.println(p01.sum(10,30));	//1차원 배열로 처라됨 -> int형식이니 형식만 맞으면 개수 제한없음
		System.out.println(p01.sum(10,20,30));
		System.out.println(p01.sum(10));
	}

}
