package awt01;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;

public class CommonsDialog extends Frame {
	public CommonsDialog() {
		setBounds(200,200,600,600);
		setTitle("��ȭ���� Ȯ���۾�");
		
		FileDialog fd = new FileDialog(this,"���� ��ȭ����");	//�̰� ���ڴٴ� �ǹ��� this
		//���丮 ����
		fd.setDirectory("C:\\Users\\503-15\\Documents\\�ڰ���\\mc\\text\\0710");
		//���� ��ȭ���� ȭ�� ���
		fd.setVisible(true);
		
		//������ ���� ��� ��������
		String path = fd.getDirectory()+fd.getFile();
		//System.out.println(path);
		Label lb1 = new Label(path);
		add(lb1);
		
		setVisible(true);
		
		
	}
}
