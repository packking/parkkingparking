package awt01;

import java.awt.*;

public class CommonsDialogTest01 extends Frame{
	public CommonsDialogTest01() {
		setBounds(200,200,500,500);//��ġ,ũ�� ����
		setTitle("���� ��ȭ����");//Ÿ��Ʋ
		
		FileDialog fdt01 = new FileDialog(this,"���� ��������");
		fdt01.setDirectory("C:\\Users\\503-15\\Pictures\\Saved Pictures");	//���� ���
		fdt01.setVisible(true);
		
		String aa = fdt01.getDirectory() + fdt01.getFile();	//������ ������ �����̸� ��������
		
		Label lbt01 = new Label(aa);	//������ ������ �����̸��� ��Ÿ���� ��
		add(lbt01);	//�����ӿ� �� �߰�
		
		setVisible(true);	//ȭ����¿���
		
	}
}
