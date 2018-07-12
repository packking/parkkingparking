package etc;

import java.nio.file.Files;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.lang.*;
import com.sun.java.util.jar.pack.Package.File;

public class ScannerMain {

	public static void main(String[] args) {
		//키보드로부터 한 줄을 입력받아서 출력
		Scanner ss = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		//한 줄을 입력받는 객체
		String name = ss.nextLine();
		
		System.out.print("이름 입력 : ");
		//공백 단위로 구분해서 입력받는 개체
		String name1 = ss.next();
		System.out.println(name+", "+name1);
		//스캐너를 사용하면 마지막엔 닫아줘야함
		ss.close();
		
		//문자열로 부터 받기
		ss = new Scanner("Hello!! Java ");
		System.out.println(ss.next());
		System.out.println(ss.next());
		//file 객체 만들기
		java.io.File f= new java.io.File("C:\\Users\\503-15\\Documents\\박경태\\mc\\text\\0711.txt");
	try {
		//데이터가 있을 때 까지 읽기
		//파일은 있는데 내용을 못 읽는 경우는 2가지
		//1.구분문자 없는 경우, 2.한글 인코딩이 서로 다른 경우
		//한글이 깨져나오는 건 인코딩버전이 달라서 그런 것
		//인코딩이 다르면 공백문자의 코드도 다름
		ss=new Scanner(f);
		while(ss.hasNext()) {
			System.out.println(ss.next());
		}
		ss.close();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}