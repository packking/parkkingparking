package Swing;

import javax.swing.*;

public class SwingTest01 extends JFrame {
	public SwingTest01() {
		setBounds(200,200,700,700);
		setTitle("Swing Test01");
		setDefaultCloseOperation(EXIT_ON_CLOSE);//윈도우메인바에 있던 종료버튼 활성화
		
		JPanel p1 = new JPanel();
		
		String [] aa = { "파랑","빨강","노랑","초록" };
		
		JList<String>list = new JList<>(aa);
		JComboBox<String>cb = new JComboBox<>(aa);
		p1.add(list);
		p1.add(cb);
		
		
		
		add("East",p1);
		
		setVisible(true);
	}
}
