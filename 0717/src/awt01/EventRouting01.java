package awt01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EventRouting01 extends Frame {
	public EventRouting01() {
		setBounds(200, 200, 500, 500);
		setTitle("�̺�Ʈ �����");

		Panel p1 = new Panel();
		Button bt1 = new Button("1�� ��ư");
		Button bt2 = new Button("2�� ��ư");
		Button bt3 = new Button("3�� ��ư");
		
		Label lb01 = new Label();

		p1.add(bt1); // 1���гο� 1����ư �߰�
		p1.add(bt2);
		p1.add(bt3);
		add("Center",p1);		//p1 �߾ӿ� ��ġ
		
		add("South",lb01);
		
		//�׼� �̺�Ʈ�� ó���� �� �ִ� �ν��Ͻ� �����	
//		ActionListener hello = new ActionListener() {	//��ư ������ Hello~!! ���
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				lb01.setText("Hello~!!");
//				
//			}
//			
//		};
//		ActionListener del = new ActionListener() {	//��ư ������ �󺧿� ���� ���� ����
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				lb01.setText("");
//				
//			}
//			
//		};
//		ActionListener ed = new ActionListener() {	//��ư ������ ���α׷� ����
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//				
//			}
//			
//		};
//		//������Ʈ�� �̺�Ʈ�� ó���� �� �ִ� ������ ����
//		bt1.addActionListener(hello);
//		bt2.addActionListener(del);
//		bt3.addActionListener(ed);
		//���� ������ EventRouting �ؼ� �̹�Ʈ �ϰ�ó���ϱ� -> ���� �з��� �̺�Ʈ�� ���ε��� �ν���Ʈ ���� 1���� ����� �޸� �����ϰ� ��
		ActionListener router = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//�̺�Ʈ�� �߻��� ������Ʈ�� ���ڿ��� ������ �б�
				switch(e.getActionCommand()) {
				case "1�� ��ư":
					lb01.setText("�ȳ��ϼ���.");
					break;
				case "2�� ��ư":
					lb01.setText("");
					break;
				case "3�� ��ư":
					System.exit(0);
					break;
				}
			}
			
		};
		//������Ʈ�� �̺�Ʈ���� router�� �ϰ�ó��
		bt1.addActionListener(router);
		bt2.addActionListener(router);
		bt3.addActionListener(router);
		
		add(p1); // �����쿡 1���г� �߰�

		setVisible(true);
	}
}
