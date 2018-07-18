package awt01;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class EventHandling02 extends Frame {
	public EventHandling02() {
		setBounds(200,200,1100,800);
		setTitle("Eventing Test2");
		
	//	Panel p1 = new Panel();
		
		setLayout(null);
		
		Label aa = new Label("@");
		aa.setBounds(20,60,30,30);
		add(aa);
		
		KeyListener moving =new KeyListener() {
			//���� Ű�� ������ ��
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			//Ű�� ������ ��
			@Override
			public void keyPressed(KeyEvent e) {
				int x=aa.getLocation().x;
				int y=aa.getLocation().y;
				if(e.getKeyCode()== KeyEvent.VK_UP) {	//������̱⿡ switch �ȵ�
					y=y-10;		//���� �ö󰡸� y�� �� �پ��	
				}
				if(e.getKeyCode()== KeyEvent.VK_DOWN) {	
					y=y+10;		//�Ʒ��� �������� y�� �� �þ
				}
				if(e.getKeyCode()== KeyEvent.VK_LEFT) {	
					x=x-10;	
				}
				if(e.getKeyCode()== KeyEvent.VK_RIGHT) {	
					x=x+10;	
				}
				aa.setLocation(x, y);
				//Modifiers �� ���� ���� ����Ű �� ����	-> e.getKeyCode()�� ���� �����
				if(e.getModifiers()==KeyEvent.SHIFT_MASK && e.getModifiers()==KeyEvent.ALT_MASK|| e.getKeyCode()==KeyEvent.VK_ENTER) {
					System.exit(0);		//VK_?? ���� �����Է� �Ұ�	-> ??_MASK�� ���� ���� ����� ����
				}
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					Label blt = new Label("x");
					blt.setBounds(aa.getLocation().x,aa.getLocation().y-30,30,30);
					add(blt);
					Thread th01 = new Thread() {
						public void run() {
							try {
								
								while(true) {
									Thread.sleep(10);
								int x=blt.getLocation().x;
								int y=blt.getLocation().y;
								blt.setLocation(x-3, y-5);
								
								if(y<100) {break;}
								}
								blt.setVisible(false);//�����Ÿ� ������ �ݺ����� �����⿡, �� �������� �Ⱥ��̰� ����
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					};
					th01.start();
				}
			}
			//Ű���� ���� �� ��
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		addKeyListener(moving);
		
	//	add(p1); // �����쿡 1���г� �߰�

		setVisible(true);
	}
}
