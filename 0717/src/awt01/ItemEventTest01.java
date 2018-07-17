package awt01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemEventTest01 extends Frame {
	public ItemEventTest01() {
		setBounds(200, 200, 500, 500);
		setTitle("������ �̺�Ʈ �׽���");

		Panel p1 = new Panel();
		Panel p2 = new Panel();

		CheckboxGroup rdo = new CheckboxGroup();
		Checkbox mn = new Checkbox("��ȥ", rdo, true);
		Checkbox my = new Checkbox("��ȥ", rdo, false);
		p1.add(mn);
		p1.add(my);

		Checkbox x1 = new Checkbox("1��");
		Checkbox x2 = new Checkbox("2��~3��");
		Checkbox x3 = new Checkbox("4��~5��");
		Checkbox x4 = new Checkbox("6�� �̻�");
		p1.add(x1);
		p1.add(x2);
		p1.add(x3);
		p1.add(x4);

		add("South", p1);

		// �� �ʿ� �ؽ�Ʈ����
		TextArea area = new TextArea(10, 70);
		add("North", area);

		// �޺��ڽ� 2�� ��ġ -> �޺��ڽ��� ��ġ�� ������ �����
		String[] ar = { "�������ּ���","�繫��", "������" };
		String[][] vr = { { "������", "����", "��ȣ��", "�ǻ�" }, { "�����", "�뿪", "������", "����" } };
		Choice cbar = new Choice();
		for (String s1 : ar) {
			cbar.add(s1);
		}
		cbar.select("�������ּ���");
		p2.add(cbar);

		Choice cbvr = new Choice();

		ItemListener cbevent = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				cbvr.removeAll();	//����� aaa cbvr.removeAll();�� �ϸ�  71�� ���� aa�ڵ带 ���� �ʾƵ� ��
				int arnb = cbar.getSelectedIndex();
				if (arnb == 1) {
					
						cbvr.removeAll();		//�׸� ��ü ����� ->���ε��� ����� ��찡 �ƴϱ⿡ -> ������ 1���� ������ ���� remove ��� ->���������� ����~��ü����=removeAll
					
					for (String s2 : vr[0]) {
						cbvr.add(s2);
					}
				} else if(arnb==2) {
					
						cbvr.removeAll();
					
					for (String s2 : vr[1]) {
						cbvr.add(s2);
					}
				}
//				else if(arnb==0){cbvr.removeAll();}	//�̰� �����ϸ� ���� �����Ͱ� ���⿡...	->aaa

			}

		};
		cbar.addItemListener(cbevent);	// ù��° �޺��ڽ����� ������ �ؾ߸� �ߵ��� �Ǳ⿡
		p2.add(cbvr);

		Button bt01 = new Button("����");
		p2.add(bt01);

		add("East", p2);
		// üũ�ڽ� ������ �� �ؽ�Ʈ���� ������ ����
		ItemListener aa = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// �̺�Ʈ�� �߻��� �ν��Ͻ��� ������ �ڷ����� üũ�ڽ��� ��ȯ
				// e.getSource() �� �̺�Ʈ�� �߻��� �ν��Ͻ��� �ּҸ� ������
				Checkbox cb = (Checkbox) (e.getSource());
				String lb = cb.getLabel(); // üũ�ڽ��� �Էµ� �ؽ�Ʈ ��������
				boolean b = cb.getState(); // üũ�ڽ� ���ÿ��� ��������
				if (b == true) {
					area.append(lb + "�� üũ����ϴ�");
				} else {
					area.append(lb + "�� üũ��ü ����ϴ�");
				}
			}
		};
		// üũ�ڽ��� ������ �� ȣ��� �ν��Ͻ� ����
		x1.addItemListener(aa);
		x2.addItemListener(aa);
		x3.addItemListener(aa);
		x4.addItemListener(aa);

		ActionListener router = new ActionListener() { // �����ư ������ ���α׷� ����ǰ�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "����") {	//��ư �ؽ�Ʈ���� "����"��� �Էµ� ��ư�� ���� �ÿ�
					System.exit(0);
				}
			}
		};
		bt01.addActionListener(router); 	//1�� ��ư�� ������ �׼��̺�Ʈ �߻�

		setVisible(true);
	}
}
