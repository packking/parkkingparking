package p01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class PrintWriterTest01 {

	public static void main(String[] args) {
		// 파일,네트워크,데이터베아스 관련 클래스들은 예외처리를 반드시 해야함
		PrintWriter pwr = null;		//널값 대입
		try {	//필수인 예외처리
			pwr  = new PrintWriter(new FileWriter("./FileTest01.txt"));
			pwr.println("ㅎㅇㅎㅇ");
			pwr.flush();//최종으로 버퍼의 내용을 전부 출력
			
		}catch(Exception e){
			System.out.println("에러 발생!!"+e.getMessage());
		}finally {
			if(pwr != null) 	//PrintWriter는 기본적으로 throws IOException e 이므로 안해도 됨
					pwr.close();

		}

	}

}
