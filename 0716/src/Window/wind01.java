package Window;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;

public class wind01 extends Frame {

		public wind01() {
//			Dialog dial01 = new Dialog(this);		//대화상자
//			dial01.setSize(100, 100);
//			dial01.setTitle("대화상자 1");
			
			
			setBackground(Color.cyan);	//배경색
			setSize(600,600);			//크기
			setLocation(100,100);		//좌표
			setTitle("윈도우 프로그램 001호");//타이틀
			
			Panel pa1 = new Panel();
			Button b1 = new Button("버튼");
//			TextThread01 tt =  new TextThread01(b1);
			Thread tt = new Thread() {
				public void run() {
					String [] arr= {"aa","bb","cc","dd","ee","ff"};
					int a=0;
					while(true) {
						try {
							Thread.sleep(1000);
							a=a+1;
							b1.setLabel(arr[a%arr.length]);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			};
			tt.start();
			b1.setLabel("버튼 텍스트 변경");
			b1.setBackground(Color.white);

//			add(b1);
			pa1.add(b1);
			
			
			Button b2 = new Button("버튼2");
//			ColorThread th1 = new ColorThread(b2);//일반적인 이 방법은 메모리 낭비이기에 anonymous class 방식으로
			Thread th1 = new Thread() {	//클래스를 따로 만들지 않았기에 생성자 생성 불가
				public void run() {
					Color [] iro = {Color.red,Color.black,Color.green};
					int a=0;
					while(true) {
						try {
							
							Thread.sleep(1000);
							a=a+1;
							b2.setBackground(iro[a%iro.length]);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
			};
			th1.start();
			pa1.add(b2);
			
			
			//패널을 프레임에 추가
			add(pa1);
			
			setVisible(true);			//보일 것인지 여부확인
			
			
//			int sign = 1;
//			
//			try {
//				Thread.sleep(1000);
//				if(sign>0) {
//					b2.setBackground(Color.red);
//				}
//				else {
//					b2.setBackground(Color.pink);
//				}
//				sign=-sign;
//			} catch (InterruptedException e) {
//
//				e.printStackTrace();
//			}
					
			
		}
}