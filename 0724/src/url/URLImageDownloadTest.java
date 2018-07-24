package url;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLImageDownloadTest {

	public static void main(String[] args) {
		try { // 이미지 다운로드 받을 주소 만들기
			String ad = "http://4cs.gia.edu/wp-content/uploads/2014/02/101672-Red-heart-ring_960.jpg";
			// ad에서 마지막 / 이후의 문자열 가져오기 - 마지막 /의 위치를 찾음
			int index = ad.lastIndexOf("/");
			String imgname = ad.substring(index + 1); // ad에서 index+1번째 글자 가져오기

			// imgname을 이용해서 저장할 파일 경로 만들기
			String filepath = "C:\\Users\\503-15\\Documents\\박경태\\mc\\0724\\" + imgname;
								//C:\\Users\\503-15\\Documents\\박경태\\mc\\0724만 쓰면
									//C:\\Users\\503-15\\Documents\\박경태\\mc\\에 저장됨
			// 파일 존재여부 확인
			if ((new File(filepath)).exists()) {
				System.out.println("이미 파일이 존재합니다!");
			} else {
				// 스레드 객체 생성 - 네트워크 사용할 때에 프로그램이 동결상태에 빠지는 것을 방지하기 위해 사용함
				Thread trd = new Thread() {
					public void run() {
						try { // 예외처리 필수
							URL url = new URL(ad); // 다운로드 받을 URL 생성
							HttpURLConnection con = (HttpURLConnection) url.openConnection(); // 연결객체 생성
							// 옵션 설정
							con.setConnectTimeout(20000);
							con.setUseCaches(false);
							// 바이트 단위로 다운로드 받기 위한 스트림 생성
							BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
							PrintStream ps = new PrintStream(filepath); // 다운로드 받은 내용을 기록할 스트림
							while (true) {
								byte[] br = new byte[512]; // 512 바이트 단위로 데이터 읽기
								int a = bis.read(br);
								if (a <= 0) {
									break;
								} // 읽은 데이터가 없으면 읽기 중단
								ps.write(br, 0, a); // 읽은 데이터를 PrintStream를 이용해서 기록
							}
							// 커넥트, 스트림들 종료
							ps.close();
							bis.close();
							con.disconnect();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				};
				trd.start(); // 스레드 시작
			}
		} catch (Exception e) {
			System.err.println("통신 오류!!" + e.getMessage());
		}

	}

}
