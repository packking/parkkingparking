package awt01;

import java.awt.*;
//import java.awt.Frame;
//import java.awt.Panel;

public class LoginMenuWindow extends Frame {
	public LoginMenuWindow(){
		//size,title
		setTitle("�α��� ȭ��");
		setSize(800,500);		//��ġ,ũ�� ���� ���ϸ� �⺻������ 0,0,0,0 �̱⿡ setVisible�� ��� ���Ǹ� �ص� ��¾ȵ�
		setLocation(200,200);
		
		//�г� ����
		Panel p1 = new Panel();
//		Label l1 = new Label();			//�̷� �������� �гο� ���� �߰�
//		TextField tf1= new TextField();
//		p1.add(l1);
//		p1.add(tf1);
		
		Label lbid = new Label("���̵� �Է�");	//���̵�
		TextField tfid = new TextField(20);
		p1.add(lbid);
		p1.add(tfid);
		
		Label pwlb = new Label("�н�����");	//pw
		TextField tfpw = new TextField(20);
		tfpw.setEchoChar('*');		//���� ���� - �Է¹��ڵ� *�� ����
		//tfpw.setEchoChar((char)ASCIInNumber);	//65�� �Է��ϸ� �ؽ�Ʈ�ʵ� ������ ���ڰ� A�� ���̵��� ����
		p1.add(pwlb);
		p1.add(tfpw);
		
		
		//Label lbaa = new Label("���� �Է�");	//���̵�
		TextArea tfaa = new TextArea(10,30);	//�� 10��,�� 30
		//p1.add(lbaa);
		p1.add(tfaa);
		
		//�޴��� ����
		MenuBar bar = new MenuBar();
		//�޴�����
		Menu file = new Menu("����(F)");
		//�޴��� �޴��ٿ� �߰�
		bar.add(file);
		
		MenuItem mn=new MenuItem("���� �����(N)");
		MenuItem mo=new MenuItem("���� ���� ����(O)");
		MenuItem ms=new MenuItem("�����ϱ�(S)");
		MenuItem mas=new MenuItem("�ٸ� �̸����� �����ϱ�(alt+S)");
		file.add(mn);	//���� �޴� �׸� ������ �޴������۵��̶� ���Ͽ� �߰�
		file.add(mo);
		file.add(ms);
		file.add(mas);
		
		Menu edit = new Menu("����(E)");
		bar.add(edit);
		
		MenuItem ex = new MenuItem("�߶󳻱�(T)");
		MenuItem ec = new MenuItem("����(C)");
		MenuItem ev = new MenuItem("�ٿ��ֱ�(V)");
		MenuItem ea = new MenuItem("��ü����(A)");
		edit.add(ex);
		edit.add(ec);
		edit.add(ev);
		edit.add(ea);
		
		
		
		
		//�޴��ٸ� �����쿡 ��ġ
		setMenuBar(bar);
		
		add(p1);	//�߰��۾� ���� ���� �г��� �����ӿ�
		
		setVisible(true);	//ȭ����¿��� Ȯ�� - false�� ���x
	}
}
