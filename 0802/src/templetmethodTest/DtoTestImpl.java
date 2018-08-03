package templetmethodTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DtoTestImpl implements DtoTest {
	//모든 메소드애서 공통으로 사용할 변수 선언
	private Connection con;			//굳이 밑의 작업들에서 반복해서 쓸 필요 없음 -> 값을 안주기에 자동적으로 null
	private PreparedStatement pst;
	private ResultSet rs;
	
	//데이터베이스 연결에 필요한 드라이버 클래스 불러오는 코드와 데이터베이스에 연결시켜주는 코드들
	private void dbconnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.5 :1521:xe", "scott", "tiger"); // 데이터베이스 연결
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private void dbConnectClose() { //db관련 작업으로 인해 연결되었던 것들 연결 해체시켜주는 코드들
			try {
				if (rs != null)rs.close();
				if (pst != null)pst.close();
				if (con != null)con.close();
			} catch (Exception e) {}
	}
	// 가장 큰 num을 찾아오는 매소드
	private int getMaxNum() {	//외부에 공개할 필요가 없는 작업이므로 private
		int result = 0; // 0아니여도 쓰지 않을 값 주어도 됨
		// select max(num) from ct

		try {
			
			dbconnect();
			
			pst = con.prepareStatement("select max(num) from ct");

			rs = pst.executeQuery();	//select 구문 전용 실행

			while (rs.next()) {
				// select 절의 첫번째 컬럼의 값을 정수로 읽어서
				// result에 저장
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {dbConnectClose();}

		return result;
	}

	@Override
	public boolean insertCt(Ct ct) {
		// TODO Auto-generated method stub
		// return false;
		boolean result = false;
		try {
			int maxnum = getMaxNum();	//가장 큰 번호를 찾는 sql		
			//pst.setInt(1, getMaxNum() +1); 을 그대로 쓰면 현재  dbconnect(); 작업 중에  저 구문의 getMaxNum();이 호출되면 
			//작업 도중에 작업이 완료된 getMaxNum(); 구문이 호출되므로 결과적으로 연결이 끊겨버리기에  int maxnum = getMaxNum();로 따로 변수를 선언해서
			//데이터 순서 입력 작업을 마저 함 
			dbconnect();
			pst = con.prepareStatement("insert into ct(num, name, pnum, address, birthday) " + "values(?,?,?,?,?)"); // sql
																														// 실행객체
																														// 생성
//			pst.setInt(1, ct.getNum());
			//가장 큰 번호 + 1 로 설정
			pst.setInt(1, maxnum +1);	//초기화(테이블삭제)가 되지 않으면  번호수치 누적된 상태에서 계속 +1	->데이터 입력 순으로 번호 정해줌
			pst.setString(2, ct.getName());
			pst.setString(3, ct.getPnum());
			pst.setString(4, ct.getAddress());
			pst.setDate(5, ct.getBirthday());

			int r = pst.executeUpdate();
			if (r == 1) { 
				result = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {dbConnectClose();}

		return result;
	}

	@Override
	public boolean updateCt(Ct ct) {	
		boolean result = false;		// 위에서 boolean을 호출했으면 기본적으로는 false를 리턴하기에  작업을 하게 되면 true로 하게끔
		try {

			dbconnect();
			pst = con.prepareStatement("update ct set name = ?, pnum = ? , address = ? , birthday = ? " + "where num = ?"); // sql
																														// 실행객체
			pst.setString(1, ct.getName());
			pst.setString(2, ct.getPnum());
			pst.setString(3, ct.getAddress());
			pst.setDate(4, ct.getBirthday());																											// 생성
			pst.setInt(5, ct.getNum());	//


			int r = pst.executeUpdate();
			if (r >0) { 
				result = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {dbConnectClose();}

		return result;
	}

	@Override
	public boolean deleteCt(int num) {
		boolean result = false;		// 위에서 boolean을 호출했으면 기본적으로는 false를 리턴하기에  작업을 하게 되면 true로 하게끔
		dbconnect();
		try {

			
			pst = con.prepareStatement("delete from ct " + "where num = ?"); // sql 실행객체																							// 생성
			pst.setInt(1, num);


			int r = pst.executeUpdate();
			if (r >0) { 
				result = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {dbConnectClose();}

		return result;
	}

	@Override
	public List<Ct> allreadCt() {
		List<Ct> list = new ArrayList<Ct>();	//읽어오는 데이터들을 저장시키기 위한 List 생성
		dbconnect();	//데이터베이스 드라이버 연결
		try {
			//sql	-> ct테이블의 데이터 전부 가져오기
			pst = con.prepareStatement("select num,name,birthday,pnum,address "+"from ct");
			rs= pst.executeQuery();
			while(rs.next()) {		//검색하는 데이터가 여러 개일 경우가 있으므로 반복문
				Ct ct = new Ct();
				ct.setNum(rs.getInt("num"));
				ct.setName(rs.getString("name"));
				ct.setBirthday(rs.getDate("birthday"));
				ct.setPnum(rs.getString("pnum"));
				ct.setAddress(rs.getString("address"));
				
				
				list.add(ct);	//읽은 데이터들을 최종적으로 list에 저장
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		dbConnectClose();	//연결 끊기
		return list;
	}

	@Override
	public List<Ct> nameCt(String name) {
		List<Ct>list = new ArrayList<Ct>();
		dbconnect();
		try {
			pst = con.prepareStatement("select num,name,birthday,pnum,address "+"from ct where name = ?");
			pst.setString(1, name);		//where 조건문에 있는 ?에 대한 데이터 바인딩
			//pst = con.prepareStatement("select num,name,birthday,pnum,address "+"from ct where name like ?");
			//pst.setString(1, "%"+name+"%");	//ex)진 만 입력 -> 이름에 진 이 들어간 회원들의 정보 전부 출력
			rs=pst.executeQuery();
			while(rs.next()) {		//검색하는 데이터가 여러 개일 경우가 있으므로 반복문
				Ct ct = new Ct();	//
				ct.setNum(rs.getInt("num"));
				ct.setName(rs.getString("name"));
				ct.setBirthday(rs.getDate("birthday"));
				ct.setPnum(rs.getString("pnum"));
				ct.setAddress(rs.getString("address"));
				
				list.add(ct);	//읽은 데이터들을 최종적으로 list에 저장
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		dbConnectClose();
		return list;
	}

	@Override
	public Set<Ct> numCt(int num) {
		// TODO Auto-generated method stub
		return null;
	}

}
