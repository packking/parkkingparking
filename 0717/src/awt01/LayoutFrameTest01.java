package awt01;

import java.awt.*;
import java.util.Random;

public class LayoutFrameTest01 extends Frame{
	public LayoutFrameTest01() {
		setBounds(200,200,500,500);//��ġ,ũ�� ����
		setTitle("���̾ƿ� �׽���");//Ÿ��Ʋ
		
		Panel p1 = new Panel();
		
//		//FlowLayout
//		p1.setLayout(new FlowLayout());	//�ǳ� ���� FlowLayout - ���� �� ��ġ ->�� ������ �ٽ� ���� ä�� 
//		//Button bt=null;
//		//������Ʈ ��ġ
//		for(int a = 0; a<10;a++) {
//			Button bt = new Button(a+"��° ��ư");
//			p1.add(bt);
//		}
		
		//BorderLayout
//		p1.setLayout(new BorderLayout());
//		Button bt01 = new Button("����");
//		p1.add("West", bt01);
//		Button bt02 = new Button("����");
//		p1.add("East", bt02);
//		Button bt03 = new Button("����");
//		p1.add("South", bt03);
//		Button bt04 = new Button("����");
//		p1.add("North", bt04);
//		Button bt05 = new Button("�߾�");
//		p1.add("Center", bt05);
		//GridLayout
//		p1.setLayout(new GridLayout(2, 3, 10, 10));	//(��,��,���鿩��,���鿩��)
//		for (int a = 0; a < 10; a++) {
//			Button bt = new Button(a + "��° ��ư");
//			p1.add(bt);
//		}
		
		
		p1.setLayout(null);		//setLayout(null)�� ��ǥ����,ũ�⺯�� �����ο�
		Label lb1 = new Label("$");
		lb1.setBounds(20, 50, 30, 30);
		add(lb1);
		
		
		add(p1);// �߰� ���� �Ŀ� �ǳ��� �����ӿ� �����ϴ� ������ ������
		
		setResizable(false);//ȭ�� ũ�� ���� ���θ� Ȯ�� - false = no , true = ok
		
		setVisible(true);
		
		Thread th1=new Thread(){
		//	int sign = 10;
			public void run() {
				while(true) {
					int x = lb1.getLocation().x;		//���� ��ǥ �ҷ�����
					int y = lb1.getLocation().y;
					//lb1.setLocation(x+10,y+10);
					Random r = new Random();
					lb1.setLocation(r.nextInt(400),r.nextInt(400));
				try {
					Thread.sleep(1000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
			}
		};
		th1.start();	//������ �۾� ����
	}
}
