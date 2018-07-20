package bytestream;

import java.io.*;

public class FileIOStream {
	public static void main(String[] args) {
		FileOutputStream fo01 = null;		//파일을 바이트 단위로 출력하는 스트림 변수
		// try, catch, finally는 각각 다른 구역
		try {
			// 예외가 발생할 가능성이 있는 구문
			fo01 = new FileOutputStream("./0720test.txt",false);	//파일 생성	. = 현재 디렉토리    true로 바꾸면 이어쓰기 가능
																								//기본은 false
//			fo01.write(98);		//파일의 1바이트 기록		//내부기록	->새로 다시 갱신하는 개념

			//			byte []  ar = {'1','2','3','4','5'};
//			fo01.write(ar);
			
			String ssr = "안녕하세요.";
			fo01.write(ssr.getBytes());	//문자열을 바이트 배열로 변환해서 기록할 때  getBytes() 사용
			
			
			fo01.flush(); 		//버퍼 내부 비우기
		} catch (Exception e) {
			// 예외가 발생했을 때 수행할 구문
			System.err.println("파일 입출력 예외 : "+e.getMessage());
			//현재 날짜,시간,예외내용을 로깅  -  파일에 기록하거나 네트워크를  통해서 서버에 전달
		} finally {
			// 예외 발생 여부에 상관없이 수행할 구문
			try {
				if (fo01 != null)
					fo01.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileInputStream fi01 = null;
		try {
			fi01 = new FileInputStream("./0720test.txt");		//해당파일 읽어오기
//			int r = fi01.read();		//1byte 씩
//			System.out.println(r);
//			byte [] b01 = new byte[4];	//4byte 씩 읽게 해줌
//			fi01.read(b01);	
//			System.out.println(b01);
			while(true) {
				byte [] b01 = new byte[8];
				int aa = fi01.read(b01);
//				System.out.println(b01);	//배열은 toString이 재정의 되지 않았기에 해시코드가 출력됨
//				for(byte ex : b01) {		//코드를 각각 출력
//					System.out.println(ex);
//				}
				System.out.println(new String(b01));	//문자열로 변환
				if(aa<=0) {break;}
			}
			
		}catch(Exception e){
			System.err.println("파일 입출력 예외 : "+e.getMessage());
		}finally {
			if (fi01 != null)
			try {
					fi01.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
