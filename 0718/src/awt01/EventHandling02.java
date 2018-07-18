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
			//문자 키를 눌렀을 때
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			//키를 눌렀을 때
			@Override
			public void keyPressed(KeyEvent e) {
				int x=aa.getLocation().x;
				int y=aa.getLocation().y;
				if(e.getKeyCode()== KeyEvent.VK_UP) {	//결과형이기에 switch 안됨
					y=y-10;		//위로 올라가면 y의 값 줄어듬	
				}
				if(e.getKeyCode()== KeyEvent.VK_DOWN) {	
					y=y+10;		//아래로 내려가면 y의 값 늘어남
				}
				if(e.getKeyCode()== KeyEvent.VK_LEFT) {	
					x=x-10;	
				}
				if(e.getKeyCode()== KeyEvent.VK_RIGHT) {	
					x=x+10;	
				}
				aa.setLocation(x, y);
				//Modifiers 는 같이 누른 조합키 값 리턴	-> e.getKeyCode()와 같이 써야함
				if(e.getModifiers()==KeyEvent.SHIFT_MASK && e.getModifiers()==KeyEvent.ALT_MASK|| e.getKeyCode()==KeyEvent.VK_ENTER) {
					System.exit(0);		//VK_?? 들은 동시입력 불가	-> ??_MASK와 같이 쓰는 방식을 권장
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
								blt.setVisible(false);//일정거리 지나면 반복문이 끝나기에, 그 시점에서 안보이게 해줌
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					};
					th01.start();
				}
			}
			//키에서 손을 뗄 때
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		addKeyListener(moving);
		
	//	add(p1); // 윈도우에 1번패널 추가

		setVisible(true);
	}
}
