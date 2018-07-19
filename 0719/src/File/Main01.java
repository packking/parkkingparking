package File;

import java.io.*;
import java.util.*;

public class Main01 {

	public static void main(String[] args) {
		// 파일에 대한 정보를 확인할 수 있는 클래스의 인스턴스 생성
		File f=new File("C:\\Users\\503-15\\Pictures\\Saved Pictures\\diht.jpg");
		//파일 존재 여부
		System.out.println(f.exists());
		//파일 길이 확인
		long size = f.length();	//바이트 단위로 나옴	->1024로 나눠야 kb단위로
		System.out.println(f.length()/1024);
		//파일 최종 수정시간 확인
		Date d = new Date(f.lastModified());	//java.util.Date로 임포트 하거나 java.sql.Date로 임포트 하면 결과 표시가 달라짐
		String up = f.getParent();		//해당 파일의 상위 디렉토리
		String fname = f.getName();		//파일이름을 나타내는 인스턴스
		//diht의 d를 제외한 부분 출력
		//d 이후의  위치를 탐색 후에 이후의 문자열 가져오기
		int index = fname.indexOf('d');
		System.out.println(index);
		if(index >=0) {		//탐색해서 없으면 음수를 리턴하기에 기본적으로 탐색을 성공하면 음수보다는 큼
			//기호를 기준으로 자를 땐 다른 것 쓰고,
			//substring은 위치로	substring(시작위치,종료위치) -> 1,4 하면 1,2,3
			fname = fname.substring(0,3);		//index에 +1 안해주면 d부터 출력
		}
		System.out.println(fname);
		//파일 이름 바꾸기
		
		
	}

}
