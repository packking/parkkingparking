package characterstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main2 {

	public static void main(String[] args) {


		
		BufferedReader bfrd = null;
		try {
			bfrd  = new BufferedReader(new FileReader("./char.txt"));
			//줄 단위로 데이터를 이어붙일 StringBuilder 생성
			StringBuilder sb = new StringBuilder();
			while(true) {
				String line = bfrd.readLine();	//버퍼드리더에서 읽어들임
				//읽은 데이터가 없으면 종료
				if(line==null) {break;}
				//데이터를 읽었으면 sb에 추가
				sb.append(line);
				}
			//읽은 내용을 String에 저장하기
			String aa = sb.toString();
			sb=null; //메모리 정리 작업
			System.out.println(aa);
		}catch(Exception e){
			System.out.println("에러 발생!!"+e.getMessage());
		}finally {
			if(bfrd!=null) 
				try{
					bfrd.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
		}
	}

}
