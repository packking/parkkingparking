package htmltest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HTML_ParsingTest01 {

	public static void main(String[] args) {
				Thread trd = new Thread() {
					public void run() {
						//스레드 작업할 내용
						try {
							URL url = new URL("https://www.daum.net");
							//url 연결객체 생성
							HttpURLConnection hurlcon = (HttpURLConnection)url.openConnection();
							//옵션설정
							//캐시 설정 여부 - 다운로드 받아놓고 다음에 다운로드 받은 데이터를 이용할 것인지 여부 설정
							hurlcon.setUseCaches(false);	//캐시 받을 것인지 선택
							hurlcon.setConnectTimeout(30000);	//접속 시도 시간
							
							//문자열을 읽기 위한 스트림 생성
							BufferedReader br = new BufferedReader(new InputStreamReader(hurlcon.getInputStream()));
							
							//다운로드 받는 문자열을 중간 저장시킬 인스턴스 생성
							//String은 자기 자신에 추가할 수 없기에 기존 내용을 복사해서 추가하는 방식이라서 
							//String에 바로 추가하면 메모리 낭비 발생
							
							//줄 단위로 데이터를 읽어서 sb에 추가
							StringBuilder sb = new StringBuilder();
							while(true) {
								String line = br.readLine();
								if(line==null) {break;}
								sb.append(line+"\n"); //스트링빌더에 저장
							}
							String html =sb.toString();	//sb 에 저장된 내용을 xml에 대입
							sb=null;		//sb에 들어있던 메모리를 정리
							
							br.close(); 	//연결 객체 정리
							hurlcon.disconnect();
//							System.out.println(html);
							
							Document doc = Jsoup.parse(html);	//html 루트를 찾아주는 기능
							
							//h2 라는 태그 전체를 가져오기
//							Elements e1 = doc.getElementsByTag("h2");
//							
							
							//screen_out 라는 태그의 데이터 전체 가져오기
							Elements e1 = 
									doc.getElementsByClass("screen_out");
							int cnt=0;
							while(cnt<e1.size()) {
								Element e = e1.get(cnt);	//데이터 1개 씩가져오기
									
								System.out.println(e.text()); 	//태그 안의 내용 출력
								cnt = cnt + 1;

						}
							
//							Element eid = doc.getElementById("mainServiceTitle");	//해당 아이디에 대한 내용 
							//id는  1개 리턴이라 Element
//							System.out.println(eid);
							
						} catch (Exception e) {
							System.err.println(e.getMessage());
							e.printStackTrace();
						}
					}
				};
				trd.start();

	}

}
