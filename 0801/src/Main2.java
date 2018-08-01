import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main2 {

	public static void main(String[] args) {
		// 데이터베이스 연결 변수 선언
		// 반드시 close()를 호출해야 하므로 finally에서 close 호출받음
		Connection con = null;
//		PreparedStatement pst = null;
//		PreparedStatement delpst = null;
		PreparedStatement upst = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//오라클의 데이터베이스 드라이버를  클래스를 불러오는 코드
			//에러 발생하면 드라이버 이름 확인 -> ojdbc6.jar이 refernced libraries 되었는 지 확인
			
			//"db url","account","password" -> db url은 db마다 입력하는 방법이 정해져있음
			//jdbc:oracle:thin:@데이터베이스가 있는 곳의 주소(아이피):데이터베이스가 있는 곳의 포트번호:데이터베이스의 sid
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.231:1521:xe", "scott", "tiger");	//데이터베이스와의 연결
			//오라클서비스가 실행되어있는 지 확인해서 켜보기,db주소나 아이디,비밀번호에 오탈자 없는 지 확인

			//SQL를 실행하는 객체 생성
			//pst = con.prepareStatement("insert into dept(deptno,dname,loc) "+"values(60,'DBMANAGER','BUSAN')");//연산자 마다 띄어쓰기
			//delpst = con.prepareStatement("delete from dept "+"where deptno=60");
			upst = con.prepareStatement("update dept set deptno=50 where deptno=60");
			//SQL을 실행 -  select를 제외한 구문 실행
			//int r = pst.executeUpdate();
			//int r2 = delpst.executeUpdate();
			int r3 = upst.executeUpdate();	//실행이 성공하면 해당 변수는 1로 리턴됨
			//if(r>0) {System.out.println("실행 성공");}	//실행 성공 여부 출력
			//if(r2>0) {System.out.println("실행 성공");}	//실행 성공 여부 출력
			if(r3>0) {System.out.println("실행 성공");}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			// 연결되있으면 반드시 연결해체
				try {
					//if (pst!=null) pst.close();	//pst의 작업이 한 번 성공했으니 작업 종료
					//if (delpst!=null) delpst.close();	//delpst의 작업이 한 번 성공했으니 작업 종료
					if (upst!=null) upst.close();
					if (con != null) con.close(); // 연결 닫기
				} catch (Exception e) {
				}
			
		}

	}

}
