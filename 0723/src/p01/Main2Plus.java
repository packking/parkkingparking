package p01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

//Main2의 연장선
public class Main2Plus {

	public static void main(String[] args) {
		// 파일,네트워크,데이터베아스 관련 클래스들은 예외처리를 반드시 해야함

		// 객체 단위로 데이터를 기록할 수 있는 클래스의 변수 선언
		ObjectInputStream obs = null; // 널값 대입
		try { // 필수인 예외처리
			// 파일에 객체 단위로 기록할 수 있는 클래스의 객체를 생성
			obs = new ObjectInputStream(new FileInputStream("./ObjectOutputStreamTest01.txt"));
			//read로 읽어올 때 오브젝트 타입으로 리턴하기 때문에 강제 형 변환을 사용해서 원래의 자료형으로 되돌려서 사용
			PokeDate pd = (PokeDate)obs.readObject();
			System.out.println(pd.getType()); //해당 파일 내부의 getName()에 해당되는 것만 읽어들임
			

		} catch (Exception e) {
			System.out.println("에러 발생!!" + e.getMessage());
		} finally {
			if (obs != null) // PrintWriter는 기본적으로 throws IOException e 이므로 안해도 됨
				try {
					obs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

		}

	}

}
