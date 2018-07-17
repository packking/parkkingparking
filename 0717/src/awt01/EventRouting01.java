package awt01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EventRouting01 extends Frame {
	public EventRouting01() {
		setBounds(200, 200, 500, 500);
		setTitle("이벤트 라우팅");

		Panel p1 = new Panel();
		Button bt1 = new Button("1번 버튼");
		Button bt2 = new Button("2번 버튼");
		Button bt3 = new Button("3번 버튼");
		
		Label lb01 = new Label();

		p1.add(bt1); // 1번패널에 1번버튼 추가
		p1.add(bt2);
		p1.add(bt3);
		add("Center",p1);		//p1 중앙에 배치
		
		add("South",lb01);
		
		//액션 이벤트를 처리할 수 있는 인스턴스 만들기	
//		ActionListener hello = new ActionListener() {	//버튼 누르면 Hello~!! 출력
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				lb01.setText("Hello~!!");
//				
//			}
//			
//		};
//		ActionListener del = new ActionListener() {	//버튼 누르면 라벨에 출력됬던 내용 제거
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				lb01.setText("");
//				
//			}
//			
//		};
//		ActionListener ed = new ActionListener() {	//버튼 누르면 프로그램 종료
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//				
//			}
//			
//		};
//		//컴포넌트와 이벤트를 처리할 수 있는 리스너 연결
//		bt1.addActionListener(hello);
//		bt2.addActionListener(del);
//		bt3.addActionListener(ed);
		//위의 내용을 EventRouting 해서 이밴트 일괄처리하기 -> 같은 분류의 이벤트를 따로따로 인스턴트 각각 1개씩 만들면 메모리 낭비하게 됨
		ActionListener router = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//이벤트가 발생한 컴포넌트의 문자열을 가지고 분기
				switch(e.getActionCommand()) {
				case "1번 버튼":
					lb01.setText("안녕하세요.");
					break;
				case "2번 버튼":
					lb01.setText("");
					break;
				case "3번 버튼":
					System.exit(0);
					break;
				}
			}
			
		};
		//컴포넌트와 이벤트들을 router로 일괄처리
		bt1.addActionListener(router);
		bt2.addActionListener(router);
		bt3.addActionListener(router);
		
		add(p1); // 윈도우에 1번패널 추가

		setVisible(true);
	}
}
