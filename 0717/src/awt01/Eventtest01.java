package awt01;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Eventtest01 extends Frame {
	public Eventtest01() {
		setBounds(200,200,500,500);
		setTitle("�̺�Ʈ ó��");
		
		Button bt1 = new Button("1�� ��ư");
		
		Panel p1 = new Panel();
		
		
		p1.add(bt1);		//1���гο� 1����ư �߰�
		
		
		add(p1);			//�����쿡 1���г� �߰�
		
		setVisible(true);
		
		//��ư ���� �� �߻��ϴ� �̺�Ʈ�� ó���ϴ� ActionLitener	->Interface�� ó��
		ActionListener lis01 = new ActionListener() {
			//�������̽��� �߻�޼ҵ带 ������ �ֱ⿡ ������ �ϸ� �޼ҵ� ����� �������
			@Override	//��ư�� �������� ȣ��Ǵ� �޼ҵ�
			public void actionPerformed(ActionEvent e) {
				// ���α׷� ����
				System.exit(0);
			}
			};
			bt1.addActionListener(lis01); 	//��ư, �����ʸ� ����
											//bt1�� �׼��̺�Ʈ�� �߻� -> lis01�� �޼ҵ帣 ȣ���ϵ��� ����
	}
}
