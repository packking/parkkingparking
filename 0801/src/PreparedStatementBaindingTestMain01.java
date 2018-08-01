import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedStatementBaindingTestMain01 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;

		Scanner ss = new Scanner(System.in);
		
		System.out.print("부서번호 : ");
		int jdeptno = ss.nextInt();
		
		System.out.print("부서이름 : ");
		ss.nextLine();	//이전에 남아있던 Enter를 제거하기 위한 코드
		String jdname = ss.nextLine();
		
		System.out.print("지역 : ");
		String jloc = ss.next();
		
		ss.close(); 	//입력이 끝났으면 반드시 닫아줘야한다
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//오라클의 데이터베이스 드라이버를  클래스를 불러오는 코드
			//에러 발생하면 드라이버 이름 확인 -> ojdbc6.jar이 refernced libraries 되었는 지 확인
			
			//"db url","account","password" -> db url은 db마다 입력하는 방법이 정해져있음
			//jdbc:oracle:thin:@데이터베이스가 있는 곳의 주소(아이피):데이터베이스가 있는 곳의 포트번호:데이터베이스의 sid
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.231:1521:xe", "scott", "tiger");	//데이터베이스와의 연결
			//오라클서비스가 실행되어있는 지 확인해서 켜보기,db주소나 아이디,비밀번호에 오탈자 없는 지 확인

			//SQL를 실행하는 객체 생성
			//pst = con.prepareStatement("insert into dept(deptno,dname,loc) "+"values("+jdeptno+",'"+jdname+"','"+jloc+"')");//하나하나 합쳐줘야함
			String sql = "insert into dept(deptno,dname,loc) "+"values(?,?,?)";
			pst = con.prepareStatement(sql);
			//데이터 바인딩		-		values(?,?,?)의 	set자료형(? 부분의 순서,입력받는 변수)
			pst.setInt(1, jdeptno);
			pst.setString(2, jdname);
			pst.setString(3, jloc);
			
			
			int r = pst.executeUpdate();		//SQL을 실행 -  select를 제외한 구문 실행
			if(r>0) {System.out.println("실행 성공");}	//실행 성공 여부 출력
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			// 연결되있으면 반드시 연결해체
				try {
					if (pst!=null) pst.close();	//pst의 작업이 한 번 성공했으니 작업 종료
					if (con != null) con.close(); // 연결 닫기
				} catch (Exception e) {
				}	
		}
	}
}
