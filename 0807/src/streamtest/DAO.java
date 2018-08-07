package streamtest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO { // 데이터베이스 연동목적의 클래스
	public DAO() {
		Connection con = null;
		CallableStatement cst = null; // 프로시저 실행목적의 Statement
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 데이터베이스 드라이버 클래스를 불러옴
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.140", "scott", "tiger"); // DB연결
			cst = con.prepareCall("{call istdeptProc(?,?,?)}"); // 만들어뒀던 프로시저 호출
			// 실제 값 데이터바인딩
			cst.setInt(1, 70);
			cst.setString(2, "상인");
			cst.setString(3, "Hongkong");

			int start = cst.executeUpdate();
			if (start > 0) {
				System.out.println("삽입 성공"); // 작업로딩이 지연되면 다른 쪽에서 같은 테이블로 작업하던 것을 커밋 해줘야 함
			} else {
				System.err.println("삽입 실패");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace(); // 오류발생 내역을 출력해줌
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (cst != null)
					cst.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
