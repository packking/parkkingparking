package asdasd;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastSendTest {

	public static void main(String[] args) {
		try {
			// 보내는 측의 멀티캐스트 소켓 만들기
			MulticastSocket mts = new MulticastSocket();// 송신 측은 포트없음
			Scanner ss = new Scanner(System.in); // 문자열 입력받기 위한 스캐너 만들기
			System.out.println("닉네임 입력 : "); // 닉네임 설정
			String nickname = ss.nextLine();
			while (true) { // 종료될 때까지 메세지 입력
				System.out.println("메세지(종료는 exit)");
				String ms = ss.nextLine();
				String asa = ss.nextLine();
				asa = nickname + "님께서 입장하셨습니다.";
				if (ms.equals("exit")) {
					ms = nickname + "님께서 채팅방을 나가셨습니다.";
					DatagramPacket dpk = new DatagramPacket(ms.getBytes(), ms.getBytes().length,
							InetAddress.getByName("230.100.50.5"), 9999);
					// 전송패킷 제작 - 내용, 길이 ,받는 곳의 주소, 포트번호
					mts.send(dpk); // 데이터전송 - 종료했다는 것을 서버에 알림
					mts.close(); // 멀티캐스트 소켓 닫기
					ss.close(); // 스캐너 닫기
					break;
				} else {
					ms = nickname + " : " + ms; // 메세지 제작
					// 전송할 패킷 만들기
					DatagramPacket dpk = new DatagramPacket(ms.getBytes(), ms.getBytes().length,
							InetAddress.getByName("230.100.50.5"), 9999);
					mts.send(dpk); // 데이터전송
				}
			}

		} catch (Exception e) {
			System.err.println("통신 오류!!" + e.getMessage());
		}

	}

}