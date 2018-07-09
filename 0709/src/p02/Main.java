package p02;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
//		//
//		long start = System.currentTimeMillis();
//		for(int a = 0;a<1000000;a++) {
//			System.out.println("Hello!");
//		}
//		long end = System.currentTimeMillis();
//		System.out.println("작업시간 : "+(end-start));
//		
//		//환경 변수 확인
//		System.out.println(System.getenv("path"));
//		//시스템 속성 확인
//		System.out.println(System.getenv("java.version"));
//		
//		Runtime abr=Runtime.getRuntime();
//		try {
//			//abr.exec/*("notepad.exe");*/("\"C:\\Program Files (x86)\\Hnc\\Hwp80\\Hwp.exe\""); //파일명이나 경로로 가능
//			abr.exec("\"C:\\Program Files\\internet explorer\\iexplore.exe\" www.naver.com");	//익스플로러로 naver.com 실행
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		String str = "Hello";
		int size = str.length();
		for(int a=0;a<size;a++) {
			char ch = str.charAt(a);	//번호에 해당되는 문자를 한 글자식 가져오는 역할
			char ch2 = str.charAt(a);
			if(ch>='a'&& ch<='z') {
				ch=(char)(ch-32);	//형변환 필수
			}
//			if(ch>='A'&& ch<='Z') {//역변환
//				ch2=(char)(ch+32);	//형변환 필수
//			}
			System.out.print(ch);
//			System.out.print(ch2);
		}
		
		
		
	}

}
