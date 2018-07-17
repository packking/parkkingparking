package awt01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemEventTest01 extends Frame {
	public ItemEventTest01() {
		setBounds(200, 200, 500, 500);
		setTitle("아이템 이벤트 테스팅");

		Panel p1 = new Panel();
		Panel p2 = new Panel();

		CheckboxGroup rdo = new CheckboxGroup();
		Checkbox mn = new Checkbox("미혼", rdo, true);
		Checkbox my = new Checkbox("기혼", rdo, false);
		p1.add(mn);
		p1.add(my);

		Checkbox x1 = new Checkbox("1번");
		Checkbox x2 = new Checkbox("2번~3번");
		Checkbox x3 = new Checkbox("4번~5년");
		Checkbox x4 = new Checkbox("6번 이상");
		p1.add(x1);
		p1.add(x2);
		p1.add(x3);
		p1.add(x4);

		add("South", p1);

		// 윗 쪽에 텍스트영역
		TextArea area = new TextArea(10, 70);
		add("North", area);

		// 콤보박스 2개 배치 -> 콤보박스에 배치할 데이터 만들기
		String[] ar = { "선택해주세요","사무직", "현장직" };
		String[][] vr = { { "공무원", "교수", "변호사", "의사" }, { "운동선수", "용역", "교섭가", "군인" } };
		Choice cbar = new Choice();
		for (String s1 : ar) {
			cbar.add(s1);
		}
		cbar.select("선택해주세요");
		p2.add(cbar);

		Choice cbvr = new Choice();

		ItemListener cbevent = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				cbvr.removeAll();	//여기다 aaa cbvr.removeAll();를 하면  71번 줄의 aa코드를 쓰지 않아도 됨
				int arnb = cbar.getSelectedIndex();
				if (arnb == 1) {
					
						cbvr.removeAll();		//항목 전체 지우기 ->따로따로 지우는 경우가 아니기에 -> 데이터 1개씩 삭제할 때나 remove 사용 ->광범위조건 제거~전체제거=removeAll
					
					for (String s2 : vr[0]) {
						cbvr.add(s2);
					}
				} else if(arnb==2) {
					
						cbvr.removeAll();
					
					for (String s2 : vr[1]) {
						cbvr.add(s2);
					}
				}
//				else if(arnb==0){cbvr.removeAll();}	//이걸 선택하면 이전 데이터가 남기에...	->aaa

			}

		};
		cbar.addItemListener(cbevent);	// 첫번째 콤보박스에서 선택을 해야만 발동이 되기에
		p2.add(cbvr);

		Button bt01 = new Button("종료");
		p2.add(bt01);

		add("East", p2);
		// 체크박스 눌렀을 때 텍스트영역 에서의 반응
		ItemListener aa = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// 이벤트가 발생한 인스턴스를 원래의 자료형인 체크박스로 변환
				// e.getSource() 는 이벤트가 발생한 인스턴스의 주소를 리턴함
				Checkbox cb = (Checkbox) (e.getSource());
				String lb = cb.getLabel(); // 체크박스에 입력된 텍스트 가져오기
				boolean b = cb.getState(); // 체크박스 선택여부 가져오기
				if (b == true) {
					area.append(lb + "가 체크됬습니다");
				} else {
					area.append(lb + "가 체크해체 됬습니다");
				}
			}
		};
		// 체크박스를 눌렀을 때 호출될 인스턴스 설정
		x1.addItemListener(aa);
		x2.addItemListener(aa);
		x3.addItemListener(aa);
		x4.addItemListener(aa);

		ActionListener router = new ActionListener() { // 종료버튼 누르면 프로그램 종료되게
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "종료") {	//버튼 텍스트에서 "종료"라고 입력된 버튼을 누를 시에
					System.exit(0);
				}
			}
		};
		bt01.addActionListener(router); 	//1번 버튼을 누르면 액션이벤트 발생

		setVisible(true);
	}
}
