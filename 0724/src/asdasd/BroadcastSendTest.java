package asdasd;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.util.Scanner;

public class BroadcastSendTest {

	public static void main(String[] args) {
		try {
			// udp 전송을 위한 보내는 측의 데이터그램소켓 만들기
			DatagramSocket ds = new DatagramSocket();// 송신 측은 포트없음
			Scanner ss = new Scanner(System.in); // 문자열 입력받기 위한 스캐너 만들기
			System.out.println("닉네임 입력 : "); // 닉네임 설정
			String nickname = ss.nextLine();
			String ms = nickname + "님께서 입장하셨습니다."; // 닉네임 전송
			DatagramPacket dpk = new DatagramPacket(ms.getBytes(), ms.getBytes().length,
					InetAddress.getByName("192.168.0.255"), 7777); // 192.168.0.까지 같아야함
			ds.send(dpk);
			while (true) { // 종료될 때까지 메세지 입력
				System.out.println("메세지 : ");
				ms = ss.nextLine();
				ms = nickname + " : " + ms; // 메세지 제작
				// 전송할 패킷 만들기
				dpk = new DatagramPacket(ms.getBytes(), ms.getBytes().length, 
						InetAddress.getByName("192.168.0.255"),7777); // 192.168.0.까지 같아야함
				ds.send(dpk); // 데이터전송
			}

		} catch (Exception e) {
			System.err.println("통신 오류!!" + e.getMessage());
		}

	}

}