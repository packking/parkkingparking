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
			public void windowClosing(WindowEvent e) {	//�����ư�޼ҵ�	//Listener�� �ٸ� �׸� �Ⱦ��ٰ� ����� ���� -> Listener�� �⺻������ �����ص־� �ϱ� ����
				System.exit(0);							//Listener��� Adapter�� ���� �߻󰳳��� �ƴϱ⿡ ���ʿ����� ������ �����۵� ���� ->�ʿ�޼ҵ�� ���� �����ؾ���
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
