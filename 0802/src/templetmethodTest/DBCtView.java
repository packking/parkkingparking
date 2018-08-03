package templetmethodTest;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class DBCtView extends JFrame {

	// 필요 ui 변수 선언

	JLabel lbNum, lbName, lbPnum, lbAddress, lbBirthday; // 레이블
	// 입력받을 텍스트필드
	JTextField tfNum, tfName, tfPnum, tfAddress, tfBirthday;
	JButton btFirst, btPrev, btNext, btLast, btInsert, btUpdate, btDelete, btSelect, btClean;

	JLabel lbPageCount; // 현재 출력 중인 데이터의 인덱스를 표시할 레이블

	DtoTest dao = new DtoTestImpl(); // 데이터베이스를 연동한 작업을 위한 변수 생성
	List<Ct> list; // 데이터베이스애서 가져온 결과를 저장하기 위한 List 생성
	int a; // 현재 출력 중인 데이터의 인덱스를 저장할 변수

	// a번째 데이터를 화면에 출력해주는 메소드
	// 맨 처음 한 번만 호출하고, 데이터에 작업이 발생하면 호출하는 메소드
	private void OutputDateView() {
		if (list.size() == 0) {
			JOptionPane.showMessageDialog(null, "읽어 낼 데이터가 없습니다", "is not date", JOptionPane.ERROR_MESSAGE);
			return;
		}

		Ct ct = list.get(a); // List에서 a번째 데이터를 가져오는 코드
		tfNum.setText(String.format("%d", ct.getNum()));
		tfName.setText(ct.getName());
		tfPnum.setText(ct.getPnum());
		tfAddress.setText(ct.getAddress());
		tfBirthday.setText(ct.getBirthday().toString()); // toString()을 사용해 문자열로 변환
		//레이블에 현재 인덱스 출력
//		lbPageCount.setText(String.format("%d", a+1));
		lbPageCount.setText((a+1)+"");
	}

	public DBCtView() { // 인스턴스를 만들 때 초기화 시키기 위해서 생성

		// 데이터 호출 관련 데이터들
		InputDate();

		// 버튼 생성 클래스 호출
		ButtonPlay();

		list = dao.allreadCt(); // 데이터베이스에서 데이터를 가져옴
		OutputDateView();

		setBounds(100, 100, 800, 400);
		setTitle("Table Ct View");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); // 창 크기 변경에 대한 여부
		setVisible(true);
	}

	private void InputDate() {
		JPanel pcenter = new JPanel(); // 중앙에 배치시킬 패널

		lbNum = new JLabel("회원번호", JLabel.RIGHT);
		lbName = new JLabel("회원이름", JLabel.RIGHT);
		lbPnum = new JLabel("전화번호", JLabel.RIGHT);
		lbAddress = new JLabel("주소", JLabel.RIGHT);
		lbBirthday = new JLabel("생년월일", JLabel.RIGHT);

		tfNum = new JTextField();
		tfName = new JTextField();
		tfPnum = new JTextField();
		tfAddress = new JTextField();
		tfBirthday = new JTextField();

		// 4행 2열로 배치시키기 위해 레이아웃으로 변경
		pcenter.setLayout(new GridLayout(5, 2, 3, 3));

		pcenter.add(lbNum);
		pcenter.add(tfNum);

		pcenter.add(lbName);
		pcenter.add(tfName);

		pcenter.add(lbPnum);
		pcenter.add(tfPnum);

		pcenter.add(lbAddress);
		pcenter.add(tfAddress);

		pcenter.add(lbBirthday);
		pcenter.add(tfBirthday);

		// JButton bt1 = new JButton();
		// JLabel lb1 = new JLabel();

		add("Center", pcenter);
	}

	private void ButtonPlay() { // 하나에서 수많은 작업이 일어나면 오버플로우 발생 가능성이 있어서 이를 방지하기 위해 여러개의 클래스를 만들어서 쪼갬
		// 버튼 생성 작업
		btFirst = new JButton("처음으로");
		btFirst.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				a = 0;
				OutputDateView();
				JOptionPane.showMessageDialog(null, "첫번째 데이터입니다.", "조회", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btPrev = new JButton("이전으로");
		btPrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (a == 0) {
					JOptionPane.showMessageDialog(null, "첫번째 데이터입니다.", "조회 에러", JOptionPane.ERROR_MESSAGE);
					return;
				}
				a = a - 1;
				OutputDateView();
			}
		});

		btNext = new JButton("다음으로");
		btNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				a = a + 1;
				if (a == list.size()) {
					JOptionPane.showMessageDialog(null, "마지막 데이터입니다", "조회 에러", JOptionPane.ERROR_MESSAGE);
					a=list.size()-1;
				}
				OutputDateView();
			}
		});
		btLast = new JButton("맨 끝으로");
		btLast.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				a=list.size()-1;
				OutputDateView();
				JOptionPane.showMessageDialog(null, "마지막 데이터입니다", "조회", JOptionPane.INFORMATION_MESSAGE);

			}	
		});
		btInsert = new JButton("삽입");
		btInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String pc=lbPageCount.getText();	
				if(!(pc.equals("삽입해주세요."))){
					//조건문을  (lbPageCount.getText().equals("삽입해주세요.")==false) 로 하면 
					//String pc=lbPageCount.getText(); 처럼 따로 변수를 쓰지 않아도 됨
					JOptionPane.showMessageDialog(null, "텍스트필드들을 비워주시고 입력해주세요!", "삽입에러",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				String num = tfNum.getText();
				String name = tfName.getText();
				String pnum = tfPnum.getText();
				String address = tfAddress.getText();
				String birthday = tfBirthday.getText();
				
				String msg="";	//메세지 관련
				if(num.trim().length()<1) {
					msg = "회원번호 입력은 필수입니다";
					
				}
				//name의 데이터가 비어있으면 메세지박스를 출력하고 리턴하기
				
				else if(name.trim().length()<2) {	//name의 공백 자르는 작업은 공백이 있든 없든 이름이 있으면 무조건 함
					msg="이름은 2자 이상을 입력해주셔야 합니다";			//이름 2자 이상 입력했는지 검사
					
				}
				//pnum의 데이터가 비어있으면 메세지박스를 출력	- 리턴으로 출력
				else if(pnum.trim().length()!=13) {	
					msg="전화번호 입력은 필수입니다";
				}
				int vw=0;	//자릿수 검사를 위한 카운트
				while(vw<pnum.length()) {
					char ch = pnum.charAt(vw);
					if(vw==0||vw==1) { {	if(ch<'0'||ch>'1') {break;}	} }
					if(vw==3||vw==8) {
						if(ch!='-') {  break; };	//010-0100-0001 이런 식인 지 판별   -을 쓰는 위치에 다른 것을 입력했으면 종료
					}
					//if( vw==2 ) {	if(ch<'0'||ch>'9') {break;}	}
					if( vw>3&&vw<8 || vw==2 || vw>8&&vw<=12) {	if(ch<'0'||ch>'9') {break;}	}
					//if( vw>8&&vw<=12 ) {	if(ch<'0'||ch>'9') {break;}	}
					vw=vw+1;	//검사가 끝나면 다음으로 넘어가기 위한 카운트 증가
				}
				if(vw!=pnum.length()) {		//생년월일을 제대로 입력했는 지의 생년월일의 길이까지 작업을 했는 지 2차 검사의 최종확인
					JOptionPane.showMessageDialog(null, "전화번호 입력란을 다시 한 번 확인해주세요.","입력 오류", 
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(address.trim().length()<1) {	
					msg = "주소 입력은 필수입니다";
					
				}
				else if (birthday.trim().length()<1) {
					msg = "생년월일 입력은 필수입니다";
			
				}
				if(msg.length()>=1) {
					JOptionPane.showMessageDialog(null, msg,"입력오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				//날짜데이터가 년도 4자리 월 2자리 일 2자리 형식인 지 조사
				if(birthday.length()!=10) {		//생년월일을 제대로 입력했는 지의 입력한 자릿수로 1차 검사
					JOptionPane.showMessageDialog(null, "생년월일은 YYYY-MM-DD 형식으로 써주시길 바랍니다.","입력 오류", 
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				int xy=0;	//자릿수 검사를 위한 카운트
				while(xy<birthday.length()) {
					char ch = birthday.charAt(xy);
					if(xy>=0&&xy<=3) { {	if(ch<'0'||ch>'9') {break;}	} }
					if(xy==4||xy==7) {
						if(ch!='-') {  break; };	//1990-01-01 이런 식인 지 판별   -을 쓰는 위치에 다른 것을 입력했으면 종료
					}
					if(xy==5) {	if(ch<'0'||ch>'1') {break;}	}
					if(xy==6 || xy==9 ) {	if(ch<'0'||ch>'9') {break;}	}
					if(xy==8) {	if(ch<'0'||ch>'3') {break;} }
					
					xy=xy+1;	//검사가 끝나면 다음으로 넘어가기 위한 카운트 증가
				}
				if(xy!=birthday.length()) {		//생년월일을 제대로 입력했는 지의 생년월일의 길이까지 작업을 했는 지 2차 검사의 최종확인
					JOptionPane.showMessageDialog(null, "생년월일은 YYYY-MM-DD 형식으로 써주시길 바랍니다.","입력 오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Ct ct = new Ct();
				ct.setNum(list.get(a).getNum());
				ct.setName(name);
				ct.setPnum(pnum);
				ct.setAddress(address);
				//yyyy-mm-dd 형식의 문자열을 가지고 Date 만들기
				int y = Integer.parseInt(birthday.substring(0,4));		//0~3번째	ex)2000
				int mm = Integer.parseInt(birthday.substring(5,7));		//5~6	ex)11
				int dd = Integer.parseInt(birthday.substring(8));		//8~	ex)12
				
				//Calendar 객체를 이용해서 Date 객체 만들기
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR,y);
				cal.set(Calendar.MONTH,dd);
				cal.set(Calendar.DAY_OF_MONTH,dd);
				Date date = new Date(cal.getTimeInMillis());
				ct.setBirthday(date);	//날짜 대입
				
				dao.insertCt(ct);
				list = dao.allreadCt();	//작업이 된 후의 리스트를 저장	-> 해주지 않으면 실행프로그램을 종료해야 변경작업이  즉시적용됨
				JOptionPane.showMessageDialog(null, "데이터가 입력됬습니다.","입력 완료", JOptionPane.INFORMATION_MESSAGE);
				a=list.size()-1;	//순차삽입 개념이라 삽입이 되었는 지 확인하기 위해 마지막 끝자락에 삽입이 제대로 됬는 지 확인하기 위해 
									//페이지카운트(인덱스)를 맨 마지막으로 해놔서 바로 확인 가능하게
				OutputDateView();
				
			}
			
		});
		btUpdate = new JButton("수정");
		btUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String num = tfNum.getText();
				String name = tfName.getText();
				String pnum = tfPnum.getText();
				String address = tfAddress.getText();
				String birthday = tfBirthday.getText();
				
				String msg="";
				if(num.trim().length()<1) {
					msg = "회원번호 입력은 필수입니다";
					
				}
				//name의 데이터가 비어있으면 메세지박스를 출력하고 리턴하기
				
				else if(name.trim().length()<1) {	//name의 공백 자르는 작업은 공백이 있든 없든 이름이 있으면 무조건 함
					msg="이름 입력은 필수입니다";
					
				}
				//pnum의 데이터가 비어있으면 메세지박스를 출력	- 리턴으로 출력
				else if(pnum.trim().length()<1) {	
					msg="전화번호 입력은 필수입니다";
					
				}
				else if(address.trim().length()<1) {	
					msg = "주소 입력은 필수입니다";
					
				}
				else if (birthday.trim().length()<1) {
					msg = "생년월일 입력은 필수입니다";
			
				}
				if(msg.length()>=1) {
					JOptionPane.showMessageDialog(null, msg,"입력오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				//날짜데이터가 년도 4자리 월 2자리 일 2자리 형식인 지 조사
				if(birthday.length()!=10) {		//생년월일을 제대로 입력했는 지의 입력한 자릿수로 1차 검사
					JOptionPane.showMessageDialog(null, "생년월일은 YYYY-MM-DD 형식으로 써주시길 바랍니다.","입력 오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int xy=0;	//자릿수 검사를 위한 카운트
				while(xy<birthday.length()) {
					char ch = birthday.charAt(xy);
					if(xy>=0&&xy<4) { {	if(ch<'0'||ch>'9') {break;}	} }
					if(xy==4||xy==7) {
						if(ch!='-') {  break; };	//1990-01-01 이런 식인 지 판별   -을 쓰는 위치에 다른 것을 입력했으면 종료
					}
					if(xy==5 || xy==6 || xy==8 || xy==9 ) {	if(ch<'0'||ch>'9') {break;}	}
					xy=xy+1;	//검사가 끝나면 다음으로 넘어가기 위한 카운트 증가
				}
				if(xy!=birthday.length()) {		//생년월일을 제대로 입력했는 지의 생년월일의 길이까지 작업을 했는 지 2차 검사의 최종확인
					JOptionPane.showMessageDialog(null, "생년월일은 YYYY-MM-DD 형식으로 써주시길 바랍니다.","입력 오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Ct ct = new Ct();
				ct.setNum(list.get(a).getNum());
				ct.setName(name);
				ct.setPnum(pnum);
				ct.setAddress(address);
				//yyyy-mm-dd 형식의 문자열을 가지고 Date 만들기
				int y = Integer.parseInt(birthday.substring(0,4));		//0~3번째	ex)2000
				int mm = Integer.parseInt(birthday.substring(5,7));		//5~6	ex)11
				int dd = Integer.parseInt(birthday.substring(8));		//8~	ex)12
				
				//Calendar 객체를 이용해서 Date 객체 만들기
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR,y);
				cal.set(Calendar.MONTH,dd);
				cal.set(Calendar.DAY_OF_MONTH,dd);
				Date date = new Date(cal.getTimeInMillis());
				ct.setBirthday(date);	//날짜 대입
				
				dao.updateCt(ct);
				list = dao.allreadCt();	//작업이 된 후의 리스트를 저장	-> 해주지 않으면 실행프로그램을 종료해야 변경작업이  즉시적용됨
				JOptionPane.showMessageDialog(null, "데이터가 수정됬습니다.","수정 완료", JOptionPane.INFORMATION_MESSAGE);
				OutputDateView();
				
			}
			
		});
		btDelete = new JButton("삭제");
		btDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int ynbox = JOptionPane.showConfirmDialog(null,"삭제하시겠습니까?","삭제", JOptionPane.YES_NO_OPTION);
				System.out.println(ynbox);
				if(ynbox==0) {	//0=yes , 1 = no
					dao.deleteCt(list.get(a).getNum());
					list = dao.allreadCt();	//작업이 된 후의 리스트를 저장	-> 해주지 않으면 실행프로그램을 종료해야 삭제작업 적용됨
					a=0;	//삭제작업 하면 인덱스 0으로 초기화
					OutputDateView();
				}
				
			}	
		});
		btSelect = new JButton("검색");
		btSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(null,"조회할 회원의 이름을 적어주세요.","이름으로 조회합니다.", JOptionPane.QUESTION_MESSAGE);
				//조회하면 테이블필드들 공백으로
				tfNum.setText("");	
				tfName.setText("");
				tfPnum.setText("");
				tfAddress.setText("");
				tfBirthday.setText("");
				if(name!=null) {
					list = dao.nameCt(name.trim());	//공백이 포함됬을 가능성도 있기에 trim 사용해서 공백 제거
					a=0;
					OutputDateView();
				}
				
			}	
		});
		btClean = new JButton("Clean");
		btClean.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//테이블필드들 공백으로
				tfNum.setText("");	
				tfName.setText("");
				tfPnum.setText("");
				tfAddress.setText("");
				tfBirthday.setText("");
				//JOptionPane.showInputDialog(null,"w","w", JOptionPane.PLAIN_MESSAGE);
				//
				lbPageCount.setText("삽입해주세요.");
			}	
		});
		lbPageCount = new JLabel("", JLabel.CENTER);

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 5, 7, 7));
		p1.setBorder(new TitledBorder("페이지"));
		p1.add(btFirst);
		p1.add(btPrev);
		p1.add(lbPageCount);
		p1.add(btNext);
		p1.add(btLast);

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1, 5, 7, 7));
		p2.setBorder(new TitledBorder("작업"));
		p2.add(btInsert);
		p2.add(btUpdate);
		p2.add(btDelete);
		p2.add(btSelect);
		p2.add(btClean);

		JPanel panellast = new JPanel(new BorderLayout());
		panellast.add("Center", p1);
		panellast.add("South", p2);

		add("South", panellast);
	}
}
