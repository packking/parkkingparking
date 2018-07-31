import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionTestingMain01 {

	public static void main(String[] args) {
		
		//사용하고자 하는 드라이버 클래스 로드(데이터베이스 종류에 따라 다름)
		//데이터베이스 연결 변수 선언
		// 반드시 close()를 호출해야 하므로 finally에서 close 호출받음
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.231:1521:xe", "scott", "tiger");
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
