package Window;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;

public class wind01 extends Frame {

		public wind01() {
//			Dialog dial01 = new Dialog(this);		//��ȭ����
//			dial01.setSize(100, 100);
//			dial01.setTitle("��ȭ���� 1");
			
			
			setBackground(Color.cyan);	//����
			setSize(600,600);			//ũ��
			setLocation(100,100);		//��ǥ
			setTitle("������ ���α׷� 001ȣ");//Ÿ��Ʋ
			
			Panel pa1 = new Panel();
			Button b1 = new Button("��ư");
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
			b1.setLabel("��ư �ؽ�Ʈ ����");
			b1.setBackground(Color.white);

//			add(b1);
			pa1.add(b1);
			
			
			Button b2 = new Button("��ư2");
//			ColorThread th1 = new ColorThread(b2);//�Ϲ����� �� ����� �޸� �����̱⿡ anonymous class �������
			Thread th1 = new Thread() {	//Ŭ������ ���� ������ �ʾұ⿡ ������ ���� �Ұ�
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
			
			
			//�г��� �����ӿ� �߰�
			add(pa1);
			
			setVisible(true);			//���� ������ ����Ȯ��
			
			
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