package swawww;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketMain {

	public static void main(String[] args) {
		try {
			//서버 소켓 생성		//서버를 키지 않으면 접속자애서 refuse 상태가 됨
			ServerSocket svs = new ServerSocket(9999);
			while(true) {
				System.err.println("Server roading......");
				//클라이언트 접속 대기 - 클라이언트가 접속하면 클라이언트와의 통신을 위한 소켓을 리턴하고 다음 줄의 코드 실행
				Socket sk = svs.accept();
				BufferedReader bfrd = new BufferedReader(new InputStreamReader(sk.getInputStream()));
				String mail = bfrd.readLine();
				System.out.println("메세지 : " + mail);
				String userif = bfrd.readLine();
				System.out.println("접속자 정보 : "+sk.getInetAddress());
				bfrd.close();
				sk.close();
			}
		}catch(Exception e) {
			System.err.println("통신 오류!!"+e.getMessage());
		}

	}

}
