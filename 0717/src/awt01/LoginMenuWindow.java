package awt01;

import java.awt.*;
//import java.awt.Frame;
//import java.awt.Panel;

public class LoginMenuWindow extends Frame {
	public LoginMenuWindow(){
		//size,title
		setTitle("로그인 화면");
		setSize(800,500);		//위치,크기 조절 안하면 기본적으로 0,0,0,0 이기에 setVisible로 출력 동의를 해도 출력안됨
		setLocation(200,200);
		
		//패널 생성
		Panel p1 = new Panel();
//		Label l1 = new Label();			//이런 형식으로 패널에 내용 추가
//		TextField tf1= new TextField();
//		p1.add(l1);
//		p1.add(tf1);
		
		Label lbid = new Label("아이디 입력");	//아이디
		TextField tfid = new TextField(20);
		p1.add(lbid);
		p1.add(tfid);
		
		Label pwlb = new Label("패스워드");	//pw
		TextField tfpw = new TextField(20);
		tfpw.setEchoChar('*');		//보안 관련 - 입력문자들 *로 보임
		//tfpw.setEchoChar((char)ASCIInNumber);	//65를 입력하면 텍스트필드 내부의 글자가 A로 보이도록 해줌
		p1.add(pwlb);
		p1.add(tfpw);
		
		
		//Label lbaa = new Label("내용 입력");	//아이디
		TextArea tfaa = new TextArea(10,30);	//행 10줄,열 30
		//p1.add(lbaa);
		p1.add(tfaa);
		
		//메뉴바 설정
		MenuBar bar = new MenuBar();
		//메뉴생성
		Menu file = new Menu("파일(F)");
		//메뉴를 메뉴바에 추가
		bar.add(file);
		
		MenuItem mn=new MenuItem("새로 만들기(N)");
		MenuItem mo=new MenuItem("기존 파일 열기(O)");
		MenuItem ms=new MenuItem("저장하기(S)");
		MenuItem mas=new MenuItem("다른 이름으로 저장하기(alt+S)");
		file.add(mn);	//파일 메뉴 항목 내부의 메뉴아이템들이라 파일에 추가
		file.add(mo);
		file.add(ms);
		file.add(mas);
		
		Menu edit = new Menu("편집(E)");
		bar.add(edit);
		
		MenuItem ex = new MenuItem("잘라내기(T)");
		MenuItem ec = new MenuItem("복사(C)");
		MenuItem ev = new MenuItem("붙여넣기(V)");
		MenuItem ea = new MenuItem("전체선택(A)");
		edit.add(ex);
		edit.add(ec);
		edit.add(ev);
		edit.add(ea);
		
		
		
		
		//메뉴바를 윈도우에 배치
		setMenuBar(bar);
		
		add(p1);	//추가작업 종료 후의 패널을 프레임에
		
		setVisible(true);	//화면출력여부 확인 - false면 출력x
	}
}
