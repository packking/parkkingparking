import java.sql.Connection;
import java.sql.DriverManager;

public class Main01 {

	public static void main(String[] args) {
		// 데이터베이스 연결 변수 선언
		// 반드시 close()를 호출해야 하므로 finally에서 close 호출받음
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//오라클의 데이터베이스 드라이버를  클래스를 불러오는 코드
			//에러 발생하면 드라이버 이름 확인 -> ojdbc6.jar이 refernced libraries 되었는 지 확인
			
			//"db url","account","password" -> db url은 db마다 입력하는 방법이 정해져있음
			//jdbc:oracle:thin:@데이터베이스가 있는 곳의 주소(아이피):데이터베이스가 있는 곳의 포트번호:데이터베이스의 sid
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.231:1521:xe", "scott", "tiger");	//데이터베이스와의 연결
			//오라클서비스가 실행되어있는 지 확인해서 켜보기,db주소나 아이디,비밀번호에 오탈자 없는 지 확인
			System.out.println(con);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			// 연결되있으면 반드시 연결해체
			if (con != null) {
				try {
					con.close(); // 연결 닫기
				} catch (Exception e) {
				}
			}
		}
	}
}