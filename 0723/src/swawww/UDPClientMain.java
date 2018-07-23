package swawww;

import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClientMain {

	public static void main(String[] args) {
		
		try {
//			InetAddress ad = InetAddress.getByName("192.168.0.231");
			DatagramSocket dsk = new DatagramSocket();	//tcp와는 다르게 데이터그램소켓을 씀
			Scanner ss = new Scanner(System.in);
			System.out.println("전송할 메세지 : ");
			String ms = ss.nextLine();
			ss.close();
			DatagramPacket dpk = new DatagramPacket(ms.getBytes(),ms.getBytes().length,InetAddress.getByName("192.168.0.231"),5000);
			
			dsk.send(dpk);//데이터 전송
		//	dsk.close();//소켓종료
		}catch(Exception e) {
			System.err.println("통신 오류!!"+e.getMessage());
		}

	}

}
