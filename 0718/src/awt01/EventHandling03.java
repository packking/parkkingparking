package awt01;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class EventHandling03 extends Frame {
	public EventHandling03() {
		setBounds(200,200,1100,800);
		setTitle("Eventing Test3");
		
		WindowListener windl = new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {	//종료버튼메소드	//Listener는 다른 항목 안쓴다고 지우면 에러 -> Listener는 기본적으로 구현해둬야 하기 때문
				System.exit(0);							//Listener대신 Adapter를 쓰면 추상개념이 아니기에 불필요목록은 지워도 정상작동 가능 ->필요메소드는 직접 제작해야함
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		addWindowListener(windl);
		
		
		
		
		
		
		setVisible(true);
	}
}
