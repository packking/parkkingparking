package awt01;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class EventHandling01 extends Frame{
	public EventHandling01() {
		setBounds(200,200,1100,800);
		setTitle("Eventing Test");
		
		Panel p1 = new Panel();
		
		TextField tf01 = new TextField(5);
		Label lb01 = new Label("+");
		TextField tf02 = new TextField(5);
		Label lb02 = new Label("=");		
		TextField tf03 = new TextField(6);	// 계산결과는 텍스트필드에 값을 다 넣은 순간에 할 것인지... 버튼 같은 걸 눌러서 할 것인지...
		p1.add(tf01);		//큐 마냥 먼저 추가한 순서대로...
		p1.add(lb01);
		p1.add(tf02);
		p1.add(lb02);
		p1.add(tf03);
		
		Button resultbt = new Button("계산");
		Button extbt = new Button("종료");
		p1.add(resultbt);
		//버튼 누르면 실행될 이벤트
		//액션리스너 인터페이스의 익명클래스
		ActionListener rst01 = new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="계산") {
				String s1 =  tf01.getText();
				String s2 =  tf02.getText();
				//문자열을 정수로 변환해서 연산
				int r = Integer.parseInt(s1)+Integer.parseInt(s2);
				tf03.setText(r+"");
				}
				if(e.getActionCommand()=="종료") {System.exit(0);}
			}
		};
		resultbt.addActionListener(rst01);	//버튼 누르면 액션이벤트 실행됨
		extbt.addActionListener(rst01);	//버튼 누르면 액션이벤트 실행됨
		Panel p2 = new Panel();
		
		p2.add(extbt);	//위에 작성해둔 종료버튼 p2에 추가
		Label lbpw = new Label("비밀번호");
		Label lbpwgrd = new Label();
		TextField tfpw = new TextField(10);
		p2.add(lbpw);
		p2.add(tfpw);
		p2.add(lbpwgrd);
		
		TextListener rst02 = new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				String pw = tfpw.getText();
				int big=0,sml=0,nb=0,etc=0;
				//pw의 모든 글자 순회
				for(int ab=0;ab<pw.length();ab++) {	
					char ch01 = pw.charAt(ab);
					if(ch01>='A'&&ch01<='Z') {//대문자일 경우
						big=big+1;
					}
					else if(ch01>='a'&&ch01<='z') {//소문자일 경우
						sml=sml+1;
					}
					else if(ch01>='0'&&ch01<='9') {//숫자일 경우
						nb=nb+1;
					}
					else {	//그 외의 문자일 경우
						etc=etc+1;
					}
				}
				if(big*sml*nb*etc>0) {	//4가지 중 1개라도 0이 없으면
					lbpwgrd.setText("사용 가능한 비밀번호입니다.");
				}
				else if(big+sml+nb+etc==0) {lbpwgrd.setText(""); }
				else{lbpwgrd.setText("비밀번호가 취약합니다.");}
				

			}
		};
		tfpw.addTextListener(rst02);	//해당 텍스트필드에 입력하면 해당 라벨에서 결과 나옴
		
		
		add("South",p2);
		add("North",p1);
		setVisible(true);
	}
}
