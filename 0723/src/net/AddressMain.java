package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressMain {

	public static void main(String[] args) {
		try {
			InetAddress iad = InetAddress.getByName("www.naver.com");
			System.out.println(iad);
			System.out.println("========================");
			InetAddress [] ar = InetAddress.getAllByName("www.daum.net");
			for(InetAddress aa : ar) {
				System.out.println(aa);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
