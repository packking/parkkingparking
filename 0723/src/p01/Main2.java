package p01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main2 {

	public static void main(String[] args) {
		// 파일,네트워크,데이터베아스 관련 클래스들은 예외처리를 반드시 해야함
		
		//객체 단위로 데이터를 기록할 수 있는 클래스의 변수 선언
				ObjectOutputStream obs = null;		//널값 대입
				try {	//필수인 예외처리
					//파일에 객체 단위로 기록할 수 있는 클래스의 객체를 생성
					obs  = new ObjectOutputStream(new FileOutputStream("./ObjectOutputStreamTest01.txt"));

					PokeDate pd = new PokeDate();
					pd.setNum(025);
					pd.setName("피카츄");
					pd.setType("전기");
					obs.writeObject(pd); 	//객체를 파일에 기록
				}catch(Exception e){
					System.out.println("에러 발생!!"+e.getMessage());
				}finally {
					if(obs != null) 	//PrintWriter는 기본적으로 throws IOException e 이므로 안해도 됨
						try {
							obs.close();
						} catch (IOException e) {
							e.printStackTrace();
						}

				}


	}

}
