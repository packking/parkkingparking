package Swing01;

import javax.swing.JFrame;
import javax.swing.border.*;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

public class WindowClass extends JFrame{
	public WindowClass() {
		setBounds(200,200,1100,800);
		setTitle("Windows ver-Swing");
		//종료버튼 이벤트처리
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel p1 = new JPanel();
		//이미지아이콘
		//ImageIcon icon01 =  new ImageIcon("C:\\Users\\503-15\\Pictures\\Saved Pictures\\diht.jpg"); 
		
		
		JLabel lb01= new JLabel();
		//lb01.setIcon(icon01);  //이 방식으로도 가능
		lb01.setToolTipText("hI~");	//툴팁기능
		//lb01.setSize(5000, 5000);
		EtchedBorder bd01 = new EtchedBorder(Color.RED,Color.cyan);
		lb01.setBorder(bd01);
		
		
		p1.add(lb01);
		
		JButton bt01 = new JButton("시작");

		//그림파일 이름을 배열로 - 배열은 크기 변경 불가
//		String [] img = {"diht.jpg","diht2.jpg"};
		//List는 크기 변경 가능한 배열
		ArrayList<String> list = new ArrayList<String>();
		list.add("diht.jpg");
		list.add("diht1.jpg");
		list.add("diht2.jpg");
		list.add("diht3.jpg");
		
		//이미지 변경 중에도 다른 작업이 가능하게 해야하므로 이미지 변경은 스레드로
		Thread th01 = new Thread() {
			public void run() {
				int index=0;
				while(true) {
					try {
						Thread.sleep(50);
//						ImageIcon icon01 =  new ImageIcon("C:\\Users\\503-15\\Pictures\\Saved Pictures\\"+img[index%img.length]); //배열로
						ImageIcon icon01 =  new ImageIcon("C:\\Users\\503-15\\Pictures\\Saved Pictures\\"+list.get(index%list.size())); 
						lb01.setIcon(icon01);
						index = index+1;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		th01.start();	//반드시 쓰자
		
		add(p1);
		setVisible(true);
	}
}
