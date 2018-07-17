package awt01;

import java.awt.*;
import java.util.Random;

public class LayoutFrameTest01 extends Frame{
	public LayoutFrameTest01() {
		setBounds(200,200,500,500);//위치,크기 설정
		setTitle("레이아웃 테스팅");//타이틀
		
		Panel p1 = new Panel();
		
//		//FlowLayout
//		p1.setLayout(new FlowLayout());	//판넬 전용 FlowLayout - 열에 다 배치 ->행 내려서 다시 열을 채움 
//		//Button bt=null;
//		//컴포넌트 배치
//		for(int a = 0; a<10;a++) {
//			Button bt = new Button(a+"번째 버튼");
//			p1.add(bt);
//		}
		
		//BorderLayout
//		p1.setLayout(new BorderLayout());
//		Button bt01 = new Button("서쪽");
//		p1.add("West", bt01);
//		Button bt02 = new Button("동쪽");
//		p1.add("East", bt02);
//		Button bt03 = new Button("남쪽");
//		p1.add("South", bt03);
//		Button bt04 = new Button("북쪽");
//		p1.add("North", bt04);
//		Button bt05 = new Button("중앙");
//		p1.add("Center", bt05);
		//GridLayout
//		p1.setLayout(new GridLayout(2, 3, 10, 10));	//(행,열,공백여부,공백여부)
//		for (int a = 0; a < 10; a++) {
//			Button bt = new Button(a + "번째 버튼");
//			p1.add(bt);
//		}
		
		
		p1.setLayout(null);		//setLayout(null)은 좌표설정,크기변경 자유로움
		Label lb1 = new Label("$");
		lb1.setBounds(20, 50, 30, 30);
		add(lb1);
		
		
		add(p1);// 추가 종료 후에 판넬을 프레임에 투입하는 것으로 마무리
		
		setResizable(false);//화면 크기 조절 여부를 확인 - false = no , true = ok
		
		setVisible(true);
		
		Thread th1=new Thread(){
		//	int sign = 10;
			public void run() {
				while(true) {
					int x = lb1.getLocation().x;		//현재 좌표 불러오기
					int y = lb1.getLocation().y;
					//lb1.setLocation(x+10,y+10);
					Random r = new Random();
					lb1.setLocation(r.nextInt(400),r.nextInt(400));
				try {
					Thread.sleep(1000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
			}
		};
		th1.start();	//스레드 작업 시작
	}
}
