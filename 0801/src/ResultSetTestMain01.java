import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ResultSetTestMain01 {
	//DEPT 테이블에서 입력받은 Deptno에 해당하는 데이터들 삭제
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null; // select 구문의 결과를 저장하기 위한 변수

		Scanner ss = new Scanner(System.in);

		System.out.print("검색할 데이터에 해당하는 부서번호를 입력해주세요  : ");
		int jdeptno = ss.nextInt();

		ss.close(); // 입력이 끝났으면 반드시 닫아줘야한다

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 오라클의 데이터베이스 드라이버를 클래스를 불러오는 코드
			// 에러 발생하면 드라이버 이름 확인 -> ojdbc6.jar이 refernced libraries 되었는 지 확인

			// "db url","account","password" -> db url은 db마다 입력하는 방법이 정해져있음
			// jdbc:oracle:thin:@데이터베이스가 있는 곳의 주소(아이피):데이터베이스가 있는 곳의 포트번호:데이터베이스의 sid
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.231:1521:xe", "scott", "tiger"); // 데이터베이스와의
																											// 연결
			// 오라클서비스가 실행되어있는 지 확인해서 켜보기,db주소나 아이디,비밀번호에 오탈자 없는 지 확인

			con.setAutoCommit(false); // 자바는 데이터베이스 연동하면 자동적으로 오토커밋 -> 이 옵션을 on/off 하는 코드

			// SQL를 실행하는 객체 생성
			pst = con.prepareStatement("select * from dept where deptno= ?");
			// 데이터 바인딩 - deptno= ? 의 set자료형(? 부분의 순서,입력받는 변수)
			pst.setInt(1, jdeptno);

			rs = pst.executeQuery(); // SQL을 실행 - select 구문 실행

			if (rs.next()) { // 읽을 데이터가 있는 지 없는 지를 확인
				System.out.println("실행 성공");
				System.out.print("DeptNo : " + rs.getInt("deptno") + " : ");
				System.out.print("DName : " + rs.getString("dname") + " : ");
				System.out.print("Loc : " + rs.getString("loc"));
				con.commit();
			} // 실행 성공 여부 출력 AutoCommit 옵션 껏을 때에는 성공했을 때 커밋하도록 커밋해주는 코드 설정
			else {
				System.out.println("조건에 맞는 데이터가 없습니다.");
			} // 조건에 맞는 데이터가 없어도 작업은 하되 catch로 감
		} catch (Exception e) {
			try {
				con.rollback(); // AutoCommit 옵션 껏을 때에 실행 실패하면 자동적으로 롤백해주는 코드 작성
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.err.println(e.getMessage()); // 예외처리를 하지 않으면 성공&실패 여부 확인이 불가

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close(); // pst의 작업이 한 번 성공했으니 작업 종료
				if (con != null)
					con.close(); // 연결 닫기
			} catch (Exception e) {
				e.printStackTrace(); // finally가 아니였으면 오류 내용들 출력
			}
		}
	}

}