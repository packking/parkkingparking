package Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.*;

public class PokeDex extends JFrame {
	
	String [] cl= {"번호","종족명","속성"};
	String [][] data = {	//실제 보여줄 데이터 입력
			{"001","이상해씨","식물"},{"004","파이리","불꽃"},{"007","꼬부기","물"},{"025","피카츄","전기"}
			};
	
	
	public PokeDex() {
		setBounds(200, 200, 1000, 1000);
		setTitle("Pokemon Date");
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 윈도우메인바에 있던 종료버튼 활성화
		JPanel p1 = new JPanel();
		

		DefaultTableModel md02 = new DefaultTableModel(data,cl);	//테이블 모델 만들기
		JTable tb01 = new JTable(md02);	//테이블 모델을 이용해서 테이블 제작
//		tb01.setModel(md02);	//기록된 데이터가 없었을 때
		//출력영역의 크기보다 테이블이 커지더라도 스크롤 바를 이용할 수 있도록 스크롤 생성
		JScrollPane scp = new JScrollPane(tb01);
		//스크럴페인 프레임에 부착
		add(scp);
		
		
		add("North", p1);
		
//		//메세지 다이알로그
//		JOptionPane.showMessageDialog(null,"메세지 다이얼로그","대화상자",JOptionPane.QUESTION_MESSAGE);
//		//선택 다이얼로그		
//		int r = JOptionPane.showConfirmDialog(null,"선택 다이얼로그","대화상자",JOptionPane.YES_NO_OPTION);
//		System.out.println(r);		//리턴해주는 값 있어야함
//		//입력다이얼로그
//		String ipt = JOptionPane.showInputDialog(null,"메세지 다이얼로그","대화상자",JOptionPane.YES_NO_OPTION);
//		System.out.println(ipt);
		
		//메뉴바 생성
		JMenuBar mbr = new JMenuBar();
		JMenu f1 = new JMenu("파일(f)");
		f1.setMnemonic('f'); //단축키 설정
		//메뉴아이템
		JMenuItem op1 = new JMenuItem("열기(o)");
		op1.setMnemonic('o'); //단축키 설정
		f1.add(op1);	//메뉴아이템을 파일이라는 메뉴에 추가
		JCheckBoxMenuItem cbi1 = new JCheckBoxMenuItem("체크박스");
		JRadioButtonMenuItem rbi1 = new JRadioButtonMenuItem("라디오박스");
		f1.add(cbi1);
		f1.add(rbi1);
		mbr.add(f1);	//파일 이라는 메뉴를 메뉴바에 추가
		
		//메뉴바를 윈도우에 추가
		setJMenuBar(mbr);
		
		JPanel p2 = new JPanel();
		
		JLabel lbname = new JLabel("종족명");
		JLabel lbpn=new JLabel("번호");
		JLabel lbad=new JLabel("속성");
		JTextField tfname = new JTextField(10);
		JTextField tfpn = new JTextField(15);
		JTextField tfad = new JTextField(30);
		
		JButton btnInsert = new JButton("추가");
		JButton btnDel = new JButton("삭제");
		p2.add(lbpn);
		p2.add(lbname);
		p2.add(lbad);
		p2.add(tfpn);
		p2.add(tfname);
		p2.add(tfad);
		p2.add(btnInsert);
		p2.add(btnDel);
		add("South",p2);
		
		//삽입 버튼의 클릭 이벤트(액션리스너)처리
		ActionListener aa = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//텍스트필드에 입력된 내용 가져오기
				
				String num = tfpn.getText();
				String name = tfname.getText();
				String type = tfad.getText();
				
				//좌우공백제거			//공백aba공백 =>aba 으로 출력
				num = num.trim();
				name = name.trim();
				type = type.trim();
				
				//num의 필수입력
				//번호가 입력되지 않는 경우는 입력글자가 없기에  입력글자의 길이도 당연히 0
				if(num.length()==0) {
					JOptionPane.showInternalMessageDialog(null,"번호는 반드시 입력해주세요!","번호",JOptionPane.WARNING_MESSAGE);//경고문
					return;	//밑 작업을 하지 않도록 리턴
				}
				
				DefaultTableModel md02=(DefaultTableModel)tb01.getModel();	//데이터 추가를 위한 형 변환
				//데이터 추가를 위해서 추가할 데이터 배열 생성
				String [] row1 = {num,name,type};
				//모델에 추가
				md02.addRow(row1);
				//테이블갱신
				tb01.updateUI();
				
				tfpn.setText("");		//삽입 작업이 끝나면 텍스트 필드 공백으로
				tfname.setText("");
				tfad.setText("");
				
				//메세지 박스 출력		//삽입 작업이 끝나면 데이터 성공관련 메세지박스 출력해줌
				JOptionPane.showMessageDialog(null,"데이터 삽입 성공","데이터 삽입 작업",JOptionPane.PLAIN_MESSAGE);	
			}
			
		};
		btnInsert.addActionListener(aa);
		
		ActionListener delete01 = new ActionListener() {	//삭제 버튼을 누르면 해당 테이블의 열 데이터 삭제
			@Override
			public void actionPerformed(ActionEvent e) {
				int tbidx =tb01.getSelectedRow();
				//테이블에서 행을 선택 안했다면
				if(tbidx<0||tbidx>=tb01.getRowCount()) {	//행을 선택하지 않았을 때에 행을 선택하도록 유도하게끔 경고문자 출력
					JOptionPane.showMessageDialog(null, "행을 선택해주세요!","행을 선택하지 않으면 삭제작업이 안됩니다.",JOptionPane.WARNING_MESSAGE);
				}
				DefaultTableModel md02=(DefaultTableModel)tb01.getModel();	//테이블의 모델 가져옴
				//모델의 데이터 삭제
				md02.removeRow(tbidx);		//테이블의 행 선택 후 삭제
				//테이블갱신
				tb01.updateUI();
				//삭제 완료하면 메세지 발송
				JOptionPane.showMessageDialog(null, "삭제를 하셨습니다.","해당 포켓몬의 데이터를 삭제했습니다.",JOptionPane.PLAIN_MESSAGE);
			}
			
		};
		btnDel.addActionListener(delete01);
		
		
		
		setVisible(true);
	}
}
