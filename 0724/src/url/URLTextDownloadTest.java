package url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class URLTextDownloadTest {

	public static void main(String[] args) {
		try {
			//1. 다운로드 받을 주소 만들기
			String ad = "https://www.naver.com";
			//한글이 포함돤 경우라면 URLEncoder.encode 메소드를 이용해서 한글을 인코딩함
			//String  query = URLEncoder.encode("한글로 된 부분","utf-8");
			
			//2. 주소를 가지고 URL 객체 생성
			URL url = new URL(ad);
			
			//3. URL 연결 객체를 생성
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			//4. 옵션 설정 - 연결이 안되면 30초까지 재시도
			con.setConnectTimeout(30000);
			con.setUseCaches(false);  	//이전에 받은 데이터가 있어도 사용하지 않도록 설정
			//5. 다운로드 받을 스트림을 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
											//con.getInputStream(),"EUC-KR"  한글 깨질 때 - 인코더 안맞을 때(charset 안맞을 때)
			//6. 데이터를 읽어서 String 으로 만들기
			StringBuilder sb = new StringBuilder();	//문자열을 복사하지 않고 편집할 수 있는 클래스의 객체 만듬
			while(true) {
				String line = br.readLine();	//한 줄의 문자열 읽기
				if(line == null) {	break;	}	//읽은 게 없으면 읽기 중단
				sb.append(line+"\n");			//읽은 데이터가 있으면 sb에 추가
			}
			String html = sb.toString();	//읽은 데이터를 String으로 변환
			System.out.println(html);
			
			//7. 사용한 객체 정리
			br.close();			//BufferedReader 종료
			con.disconnect();//URLConnection 연결끊기
			
		}catch(Exception e) {
			System.err.println("통신 오류!!"+e.getMessage());
		}

	}

}
