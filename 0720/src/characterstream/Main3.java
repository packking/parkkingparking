package characterstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main3 {

	public static void main(String[] args) {
		BufferedReader bfrd = null;
		try {
			bfrd  = new BufferedReader(new FileReader("./access_log.txt"));
			//접속한 아이피를 중복되더라도 저장하기 위한 자료구조
			ArrayList<String> list= new ArrayList();
			//중복 x
			Set<String> set = new HashSet();
			while(true) {
				String line = bfrd.readLine();	//버퍼드리더에서 읽어들임
				//읽은 데이터가 없으면 종료
				if(line==null) {break;}
				//공백 기준으로 분할작업
				String [] ar = line.split(" ");

				list.add(ar[0]);	//자른 거 배열투입
				set.add(ar[0]);
				}
//			System.out.println(list);
//			System.out.println(set);
			for(String ip : list) {
				System.out.println(ip);
			}
//			for(String ip : set) {
//				System.out.println(ip);
//			}
		}catch(Exception e){
			System.out.println("에러 발생!!"+e.getMessage());
		}finally {
			if(bfrd!=null) 
				try{
					bfrd.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
		}

	}

}
