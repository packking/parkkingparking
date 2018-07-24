package asdasd;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class BroadcastReciveTest {

	public static void main(String[] args) {
		try {
			//udp방식으로 받는 측의 멀티캐스트 소켓 만들기 - 포트번호 반드시 있어야함
			DatagramSocket ds = new DatagramSocket(7777);
			System.out.println("Server Roading........");
//			mts.joinGroup(InetAddress.getByName("230.100.50.5"));	//브로드캐스트는 브로드캐스트의 주소를 받기에 필요없음
			while(true) {
				byte [] br = new byte[512];	//바이트배열 생성
				DatagramPacket dpk = new DatagramPacket(br,512); //메세지 저장할 데이터그램 패킷 생성 - 바이트배열명,크기
				ds.receive(dpk);				//데이터 받기 - 데이터 올 때까지 대기함 - 소켓.recive(데이터그램패킷);
				String ms = new String(br);		//데이터 읽기  - 바이트배열을 문자열로 변환
				System.out.println(ms.trim());	//512바이트가 안되면 공백 제거 후 출력
				
			}
		}catch(Exception e) {
			System.err.println("통신 오류!!"+e.getMessage());
		}

	}

}
