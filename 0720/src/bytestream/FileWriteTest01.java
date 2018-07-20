package bytestream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest01 {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("./char.txt");
			fw.write("밤에 구슬피 피는 꽃이여...\n");
			fw.write("붉게 지며 떨어지는 꽃이여...\n");
			fw.write("어둑한 하늘 아래서 슬피 울지 마나이다");
			fw.flush();
		}catch(Exception e){
			System.err.println("에러가 발생했습니다!!"+e.getMessage());
		}finally{		//예외 상관없이 수행할 구문
			try {
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileReader fr = null;
		try {
			fr = new FileReader("./char.txt");
			char [] ar = new char[100];	//바이트 = 128   문자=64  
			/* while(true){				//해결방법 1 -> 배열을 반복문 내부에 생성
			 *		
			 * int r = fr.read(ar);			//ar배열의 크기 만큼 읽어서 ar에 저장하고, 읽은 갯수를 r에 저장
			 * if(r<=0){
			 * 	 break;
			 *  }
			 *  System.out.print(r);	//해결방법 2 -> System.out.print(ar,0,r);
			 * }*/													//배열 0번째~r까지만큼 문자열로 변환해서 출력
			fr.read(ar);
			System.out.println(fr);	//해밍코드
			for(char job : ar) {
				System.out.print(job);
			}
		}catch(Exception e){
			System.err.println("에러가 발생했습니다!!"+e.getMessage());
		}finally {
			if (fr != null)
			try {
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
