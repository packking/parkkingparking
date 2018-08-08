import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParsing02 {

	public static void main(String[] args) {
				Thread trd = new Thread() {
					public void run() {
						//스레드 작업할 내용
						try {
							URL url = new URL("https://apis.daum.net/local/v1/search/category.json?apikey=465b06fae32febacbc59502598dd7685&code=AT4&location=37.514322572335935,127.06283102249932&radius=20000");
							//url 연결객체 생성
							HttpURLConnection hurlcon = (HttpURLConnection)url.openConnection();
							//옵션설정
							//캐시 설정 여부 - 다운로드 받아놓고 다음에 다운로드 받은 데이터를 이용할 것인지 여부 설정
							hurlcon.setUseCaches(false);	//캐시 받을 것인지 선택
							hurlcon.setConnectTimeout(30000);
							
							//문자열을 읽기 위한 스트림 생성
							BufferedReader br = new BufferedReader(new InputStreamReader(hurlcon.getInputStream()));
							
							//줄 단위로 데이터를 읽어서 sb에 추가
							StringBuilder sb = new StringBuilder();
							while(true) {
								String line = br.readLine();
								if(line==null) {break;}
								sb.append(line); //스트링빌더에 저장
							}
							String js =sb.toString();	//sb 에 저장된 내용을 js에 대입
							
							//JSON 문자열 파싱	-	 문자열을 JSONObject로 변경
							JSONObject jsobj1 = new JSONObject(js);
							System.out.println(jsobj1);
							
							
							//channel 키의 데이터를  JSONObject타입으로 가져오기
							JSONObject channel = jsobj1.getJSONObject("channel");
							System.out.println(channel);
							
							//channel에서 item 키의 객체를  배열ar로 가져오기
							JSONArray ar = channel.getJSONArray("item");
							System.out.println(ar);
							
							//배열 순회
							int a=0;
							while(a<ar.length()) {	//item의 데이터 갯수까지
								JSONObject arraydata = ar.getJSONObject(a);	//배열 순서대로 데이터 빼내고
								String outputdata1 = arraydata.getString("address"); //그 데이터에서 "address"에 해당하는 것들만
								String outputdata2 = arraydata.getString("addressBCode"); //"addressBCode"에 해당하는 것들만
								System.out.printf("%s : %s \n",outputdata1,outputdata2);
								a++;
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
