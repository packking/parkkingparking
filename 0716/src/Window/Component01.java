package Window;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;

public class Component01 extends Frame{
	public Component01() {
		setTitle("üũ�ڽ� �׽�Ʈ");
		setLocation(200,200);
		setSize(700,700);
		
		Panel p1 = new Panel();
		
		Checkbox cd1 = new Checkbox("��ǻ��");
		Checkbox cd2 = new Checkbox("����");
		Checkbox cd3 = new Checkbox("�ڵ���");
		Checkbox cd4 = new Checkbox("���");
		Checkbox cd5 = new Checkbox("����");
		
		p1.add(cd1);
		p1.add(cd2);
		p1.add(cd3);
		p1.add(cd4);
		p1.add(cd5);
		
		//�����ڽ� ����
		CheckboxGroup g = new CheckboxGroup(); 
		Checkbox m = new Checkbox("����",g,true);
		Checkbox w = new Checkbox("����",g,false);
		p1.add(m);
		p1.add(w);
		
		//���ùڽ�
		Choice cb = new Choice();
		cb.add("�౸");	//�޺��ڽ� �׸���� ����
		cb.add("�߱�");
		cb.add("�豸");
		cb.add("��");
		p1.add(cb);		//�׸����� �Ϸ� �Ŀ� �޺��ڽ� ����
		
		//List 
		List list= new List();
		list.add("�Ʊ���");
		list.add("���Ǹ�");
		list.add("�ǿ��");
		list.add("�ȸ�");
		list.add("��Ÿ��");
		p1.add(list);		//�׸����� �Ϸ� �Ŀ� List ����
		//����Ʈ�� remove(int idx)�� ����ϸ� idx ��°�� ���� �� ����
		//list.remove(0);
		//ù��°�� �ִ� �Ʊ���,5�� °�� �ִ� ��Ÿ���� ����
//		list.remove(0);		//�����Ǹ� ��ĭ ä�����.. 0���� ���Ǹ� 1���� �ǿ�� 
//		list.remove(3);
		list.remove(4);		//�� ��ȣ �׸��� ������ ������ ��ġ�⿡  �ǵ����̸� �� ��ȣ���� ����⸦...
		list.remove(0);
		
		add(p1);		//���� �ǳ� ����
		
		setVisible(true);
	}


}
