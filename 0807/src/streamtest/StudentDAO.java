package streamtest;

//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class StudentDAO {
	//StudentDAO 클래스에서 모든 데이터를 가져오는 메소드
	public List<StudentVO> fetch() {
		// 리스트를 리턴해야 하는 경우에는 널을 리턴하지 않는 게 좋습니다.
		// 리스트는 특별한 경우가 아니면 빠른 열거를 이용해서 접근 -> 이 때는 널 이면 널포인터예외 발생
		// 널 을 안만들기 위해서는 인스턴스를 생성해서 리턴
		List<StudentVO> list = new ArrayList<StudentVO>();

		Connection con = null;
		//CallableStatement cst = null; // 프로시저 실행목적의 Statement
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 데이터베이스 드라이버 클래스를 불러옴
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.140", 
					"scott", "tiger"); // DB연결
			pst = con.prepareCall("select num,name,subject,score,age,gender "
					+ "from Student"); // 만들어뒀던 프로시저 호출

			rs = pst.executeQuery();
			while (rs.next()) {
				StudentVO vo = new StudentVO(
						rs.getString("num"), rs.getString("name"),
						rs.getString("subject"), rs.getInt("score"),
						rs.getString("gender"),rs.getInt("age"));
					list.add(vo);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace(); // 오류발생 내역을 출력해줌
		} finally {
			try {
				if (rs != null)rs.close();
				if (pst != null)pst.close();
//				if (cst != null)cst.close();
				if (con != null)con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}
}
