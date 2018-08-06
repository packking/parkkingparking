package ProcedureTest01;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main02_deleteProcedure {

	public static void main(String[] args) {
		Connection con = null;
		CallableStatement cst = null; // 프로시저 실행목적의 Statement
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 데이터베이스 드라이버 클래스를 불러옴
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.5", "scott", "tiger"); // DB연결
			cst = con.prepareCall("{call deldeptProc(?)}"); // 만들어뒀던 프로시저 호출
			// 실제 값 데이터바인딩
			cst.setInt(1, 70);

			int start = cst.executeUpdate();
			if (start > 0) {
				System.out.println("삭제 성공"); // 작업로딩이 지연되면 다른 쪽에서 같은 테이블로 작업하던 것을 커밋 해줘야 함
			} else {
				System.err.println("삭제 실패");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace(); // 오류발생 내역을 출력해줌
		} finally {
			try { // 작업이 끝났으니 db와 연결되있는 것들 연결종료
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
