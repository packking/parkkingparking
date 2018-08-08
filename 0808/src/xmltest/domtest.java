package xmltest;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class domtest {
	//넘겨받은 데이터 중에서 tmx 태그의 모든 값을 출력하기
	public static void main(String[] args) {
		Thread trd = new Thread() {
			public void run() {
				//스레드 작업할 내용
				try {
					URL url = new URL("http://www.prism.go.kr/homepage/theme/retrieveThemeRss.do;jsessionid=AE2D5C029A1781F9CA903C1A99D0A61D.node02?cond_brm_super_id=NB000120061213100114178");
					//url 연결객체 생성
					HttpURLConnection hurlcon = (HttpURLConnection)url.openConnection();
					//옵션설정
					//캐시 설정 여부 - 다운로드 받아놓고 다음에 다운로드 받은 데이터를 이용할 것인지 여부 설정
					hurlcon.setUseCaches(false);	//캐시 받을 것인지 선택
					hurlcon.setConnectTimeout(30000);	//접속 시도 시간
					
					//문자열을 읽기 위한 스트림 생성
					BufferedReader br = new BufferedReader(new InputStreamReader(hurlcon.getInputStream()));
					
					//줄 단위로 데이터를 읽어서 sb에 추가
					StringBuilder sb = new StringBuilder();
					while(true) {
						String line = br.readLine();
						if(line==null) {break;}
						sb.append(line); //스트링빌더에 저장
					}
					String xml =sb.toString();	//sb 에 저장된 내용을 xml에 대입
					System.out.println(xml);
					
					//xml 문자열을 파싱할 수 있는 객체를 생성
					DocumentBuilderFactory fc = DocumentBuilderFactory.newInstance();
					DocumentBuilder docb = fc.newDocumentBuilder();
					
					//파싱할 문자열을 스트림으로 변환
					InputStream is= new ByteArrayInputStream(xml.getBytes());
					//문자열을 파싱 수행
					Document doc = docb.parse(is);
					//속성이 루트인 것을 찾는 작업 -> 루트 찾기
					Element root = doc.getDocumentElement();
					System.out.println(root);
					
					//title 태그 전부 찾기
					NodeList nlist = root.getElementsByTagName("title");
					NodeList nlist1 = root.getElementsByTagName("description");
					NodeList nlist2 = root.getElementsByTagName("link");
					System.out.println(nlist);
					
					int cnt=0;
					while(cnt<nlist.getLength()) {
						//Thread.sleep(10000);
						Node item = nlist.item(cnt);	//해당 리스트의 (cnt)번째에 해당하는 아이템을 노드에 대입
						Node item1 = nlist1.item(cnt);
						Node item2 = nlist2.item(cnt);
						
						Node chd = item.getFirstChild();	//첫번째 하위노드 찾기
						Node chd1 = item1.getFirstChild();
						Node chd2 = item2.getFirstChild();
						//데이터 찾기
						String tmx = chd.getNodeValue();	//첫번째 하위 노드의 값을 가져와서 tmx에 투척
						String tmx1 = chd1.getNodeValue();
						String tmx2 = chd2.getNodeValue();
						
						tmx1=tmx1.replaceAll("<p>","");	//replaceAll(a,b)->a라는 문장이 나오면 b로 변경해서 대처
						tmx1=tmx1.replaceAll("</p>","");
						System.out.println(tmx+" , "+tmx1+" , "+tmx2);
						cnt = cnt + 1;

					}
					
					
				} catch (Exception e) {
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
			}
		};
		trd.start();

	}

}
