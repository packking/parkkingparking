package etc;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class LogMain {

	public static void main(String[] args) {
		//로그 파일의 내용을 읽을 수 있는 Scanner 만들기
		File f = new File("C:\\Java\\java\\log.txt");
		HashSet<String> set = new HashSet<String>();
		try {//파일 내용을 읽는 스캐너 인스턴스 생성
			Scanner sc = new Scanner(f);
			int sum = 0;	//합계 저장
			while(sc.hasNextLine()) {
				//System.out.println(sc.nextLine());
				//한 줄 읽기
				String temp = sc.nextLine();
				//공백으로 분할하기
				String [] ar = temp.split(" ");	
				//System.out.println(ar[9]);	//10번째 데이터 확인
				
				//10번째 문자열을 정수로 변환해서 더하기
				sum = sum+Integer.parseInt(ar[9]);
			}
			System.out.println(set);
			System.out.println("트래픽 합계 : "+sum);
			sc.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}