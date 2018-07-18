package awt01;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class EventHandling01 extends Frame{
	public EventHandling01() {
		setBounds(200,200,1100,800);
		setTitle("Eventing Test");
		
		Panel p1 = new Panel();
		
		TextField tf01 = new TextField(5);
		Label lb01 = new Label("+");
		TextField tf02 = new TextField(5);
		Label lb02 = new Label("=");		
		TextField tf03 = new TextField(6);	// ������� �ؽ�Ʈ�ʵ忡 ���� �� ���� ������ �� ������... ��ư ���� �� ������ �� ������...
		p1.add(tf01);		//ť ���� ���� �߰��� �������...
		p1.add(lb01);
		p1.add(tf02);
		p1.add(lb02);
		p1.add(tf03);
		
		Button resultbt = new Button("���");
		Button extbt = new Button("����");
		p1.add(resultbt);
		//��ư ������ ����� �̺�Ʈ
		//�׼Ǹ����� �������̽��� �͸�Ŭ����
		ActionListener rst01 = new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="���") {
				String s1 =  tf01.getText();
				String s2 =  tf02.getText();
				//���ڿ��� ������ ��ȯ�ؼ� ����
				int r = Integer.parseInt(s1)+Integer.parseInt(s2);
				tf03.setText(r+"");
				}
				if(e.getActionCommand()=="����") {System.exit(0);}
			}
		};
		resultbt.addActionListener(rst01);	//��ư ������ �׼��̺�Ʈ �����
		extbt.addActionListener(rst01);	//��ư ������ �׼��̺�Ʈ �����
		Panel p2 = new Panel();
		
		p2.add(extbt);	//���� �ۼ��ص� �����ư p2�� �߰�
		Label lbpw = new Label("��й�ȣ");
		Label lbpwgrd = new Label();
		TextField tfpw = new TextField(10);
		p2.add(lbpw);
		p2.add(tfpw);
		p2.add(lbpwgrd);
		
		TextListener rst02 = new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				String pw = tfpw.getText();
				int big=0,sml=0,nb=0,etc=0;
				//pw�� ��� ���� ��ȸ
				for(int ab=0;ab<pw.length();ab++) {	
					char ch01 = pw.charAt(ab);
					if(ch01>='A'&&ch01<='Z') {//�빮���� ���
						big=big+1;
					}
					else if(ch01>='a'&&ch01<='z') {//�ҹ����� ���
						sml=sml+1;
					}
					else if(ch01>='0'&&ch01<='9') {//������ ���
						nb=nb+1;
					}
					else {	//�� ���� ������ ���
						etc=etc+1;
					}
				}
				if(big*sml*nb*etc>0) {	//4���� �� 1���� 0�� ������
					lbpwgrd.setText("��� ������ ��й�ȣ�Դϴ�.");
				}
				else if(big+sml+nb+etc==0) {lbpwgrd.setText(""); }
				else{lbpwgrd.setText("��й�ȣ�� ����մϴ�.");}
				

			}
		};
		tfpw.addTextListener(rst02);	//�ش� �ؽ�Ʈ�ʵ忡 �Է��ϸ� �ش� �󺧿��� ��� ����
		
		
		add("South",p2);
		add("North",p1);
		setVisible(true);
	}
}
