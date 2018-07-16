package Window;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;

public class Component01 extends Frame{
	public Component01() {
		setTitle("체크박스 테스트");
		setLocation(200,200);
		setSize(700,700);
		
		Panel p1 = new Panel();
		
		Checkbox cd1 = new Checkbox("컴퓨터");
		Checkbox cd2 = new Checkbox("전기");
		Checkbox cd3 = new Checkbox("자동차");
		Checkbox cd4 = new Checkbox("기계");
		Checkbox cd5 = new Checkbox("생명");
		
		p1.add(cd1);
		p1.add(cd2);
		p1.add(cd3);
		p1.add(cd4);
		p1.add(cd5);
		
		//라디오박스 생성
		CheckboxGroup g = new CheckboxGroup(); 
		Checkbox m = new Checkbox("남자",g,true);
		Checkbox w = new Checkbox("여자",g,false);
		p1.add(m);
		p1.add(w);
		
		//선택박스
		Choice cb = new Choice();
		cb.add("축구");	//콤보박스 항목부터 투입
		cb.add("야구");
		cb.add("배구");
		cb.add("농구");
		p1.add(cb);		//항목투입 완료 후에 콤보박스 투입
		
		//List 
		List list= new List();
		list.add("아구몬");
		list.add("파피몬");
		list.add("피요몬");
		list.add("팔몬");
		list.add("텐타몬");
		p1.add(list);		//항목투입 완료 후에 List 투입
		//리스트의 remove(int idx)를 사용하면 idx 번째를 지울 수 있음
		//list.remove(0);
		//첫번째에 있는 아구몬,5번 째에 있는 텐타몬을 제거
//		list.remove(0);		//삭제되면 빈칸 채우듯이.. 0번에 파피몬 1번에 피요몬 
//		list.remove(3);
		list.remove(4);		//앞 번호 항목은 순서에 영향을 미치기에  되도록이면 뒷 번호부터 지우기를...
		list.remove(0);
		
		add(p1);		//최종 판넬 투입
		
		setVisible(true);
	}


}
