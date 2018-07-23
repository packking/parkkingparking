package swawww;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerMain {

	public static void main(String[] args) {
		// UDP 전송을 받는 곳
		try{
			DatagramSocket ds = new DatagramSocket(9999);	//받는 측은 포트 반드시 입력
			while(true) {									//서버, 클라이언트 서로 포트 맞아야 통신에 지장없음
				byte [] br = new byte[1024]; //데이터 저장을 위한 배열 생성
				//데이터그램패킷 생성
				DatagramPacket dpac = new DatagramPacket(br,1024);
				ds.receive(dpac);	//데이터 받기
				String ms = new String(br,0,1024);//데이터 읽어서 출력			(바이트 배열, 시작위치, 길이)
				System.out.println("보낸 곳 : "+dpac.getAddress());
				System.out.println("메세지 : " + ms);
			}
		}catch(Exception e) {
			System.err.println("통신 오류!!"+e.getMessage());
		}

	}

}
