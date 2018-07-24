package asdasd;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastRecevieTest {

	public static void main(String[] args) {
		try {
			//받는 측의 멀티캐스트 소켓 만들기
			MulticastSocket mts = new MulticastSocket(9999);
			mts.joinGroup(InetAddress.getByName("230.100.50.5"));	//그룹 참여 224.0.0.0~239.255.255.255
			while(true) {
				byte [] br = new byte[512];	//바이트배열 생성
				DatagramPacket dpk = new DatagramPacket(br,512); //데이터 전송받을 패킷 만들기 - 바이트배열명,크기
				mts.receive(dpk);				//데이터 받기 - 데이터 올 때까지 대기함 - 소켓.recive(데이터그램패킷);
				String ms = new String(br);		//바이트배열을 문자열로 변환
				System.out.println(ms.trim());	//공백 제거 후 출력
			}
		}catch(Exception e) {
			System.err.println("통신 오류!!"+e.getMessage());
		}

	}

}
