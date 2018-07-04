//Scanner 클래스를 패키지 이름을 생략하고 사용 가능케 해줌
import java.util.Scanner;
import java.util.*;	//java.util. 패키지 내부의 모든 클래스들을 패키지명칭을 생략하고 사용 가능케 해줌

//Date 클래스는 java.sql.,java.util. 두 패키지에 모두 있음
//이와 같이 패키지가 다른 동명의 클래스는 반드시 구체적으로 import를 해줘야함
import java.sql.*;
import java.util.Date;
public class test01 {

	public static void main(String[] args) {
		Scanner ss = new Scanner(System.in);
		Date dd = new Date();
		
		ss.close();

	}

}
