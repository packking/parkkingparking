package swawww;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientMain {

	public static void main(String[] args) {
		try {
			//서버접속
			InetAddress ad = InetAddress.getByName("192.168.0.231");
			Socket sk = new Socket(ad,9999);
			Scanner ss = new Scanner(System.in);
			System.out.println("전송할 메세지 : ");
			String ms = ss.nextLine();
			ss.close();
			//전송할 스트림 생성
			PrintWriter  pwr = new PrintWriter(sk.getOutputStream());
			//데이터 전송
			pwr.println(ms);
			pwr.flush();
			sk.close();//소켓종료
		}catch(Exception e) {
			System.err.println("통신 오류!!"+e.getMessage());
		}
		

	}

}
