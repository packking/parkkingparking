package pack001;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		p01 pp1 = new pp01();
		pp1.call();
		
		p01 xp1 = new pp02();
		xp1.call();
		
		final int AMEG=0;//final변수 - 값 변경 불가, 지역변수지만 전역변수처럼 메모리에서 소멸되지 않음
		//AMEG=1; //변경불가 파이널 변수이기에 경고
		
//		int cmd=1;
//		final int lbutton=1,rbutton=2,While=0;
//		
//		if(cmd==lbutton) {}		//숫자로 비교하는 것보다 변수를 사용하면 어느 용도로 사용되는 지 알 수 있음  
//		else if(cmd==rbutton) {}
//		else if(cmd==While) {}
//		else {}
		
		//인터페이스로도 변수 제작이 가능하고, 이로 만든 변수는 자신을 임플리먼츠 한 클래스의 인스턴스의 주소를 저장 가능
		p02 log = new inter01();
		
		Scanner ss = new Scanner(System.in);
		System.out.print("아이디를 입력해주세요    : ");
		String id = ss.nextLine();

		
		//아이디 체크
		boolean rest = log.idcheak(id);	//입력받은 id값 필요
		if(rest==true) {
			System.out.println("사용이 가능합니다.");
		}
		else {
			System.out.println("이미 존재하는 아이디입니다");
		}
		
		
while(true) {
		System.out.print("아이디를 입력해주세요     : ");
		id=ss.nextLine();
		System.out.print("비밀번호를 입력해주세요  : ");
		String pw = ss.nextLine();
		int pass = log.login(id,pw);
		
		if(pass==1) {
			System.out.println("비밀번호가 틀리셨으니 다시 확인해주시길 바랍니다.");
		}
		else if(pass==2) {
			System.out.println("해당 아이디는 존재하지 않습니다.");
		}
		else if(pass==0) {
			System.out.println("로그인이 성공하셨습니다.");
			break;
		}
		else {System.out.println("아이디와 비밀번호를 다시 확인해주시길 바랍니다.");}

}
		


		
	}

}
