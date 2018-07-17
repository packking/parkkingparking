package awt01;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Eventtest01 extends Frame {
	public Eventtest01() {
		setBounds(200,200,500,500);
		setTitle("이벤트 처리");
		
		Button bt1 = new Button("1번 버튼");
		
		Panel p1 = new Panel();
		
		
		p1.add(bt1);		//1번패널에 1번버튼 추가
		
		
		add(p1);			//윈도우에 1번패널 추가
		
		setVisible(true);
		
		//버튼 누를 때 발생하는 이벤트를 처리하는 ActionLitener	->Interface가 처리
		ActionListener lis01 = new ActionListener() {
			//인터페이스는 추상메소드를 가지고 있기에 재정의 하면 메소드 모양이 만들어짐
			@Override	//버튼이 눌러지면 호출되는 메소드
			public void actionPerformed(ActionEvent e) {
				// 프로그램 종료
				System.exit(0);
			}
			};
			bt1.addActionListener(lis01); 	//버튼, 리스너를 연결
											//bt1에 액션이벤트가 발생 -> lis01의 메소드르 호출하도록 설정
	}
}
