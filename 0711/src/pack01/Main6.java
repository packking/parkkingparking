package pack01;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.TreeSet;

public class Main6 {

	public static void main(String[] args) {
//		LinkedList<String>l1 = new LinkedList();//링키드리스트	-	 저장된 순서대로 출력
//		HashSet<String>l1 = new HashSet();		//첫회에 랜덤배치 ->이후에는 새로 갱신할 때까지는 고정
//		LinkedHashSet<String>l1 = new LinkedHashSet();	//	-	저장된 순서대로 출력
		TreeSet<String>l1 = new TreeSet();	//-	 데이터 크기대로 -> 숫자 영문 특문
		l1.add("파이리");
		l1.add("꼬부기");
		l1.add("이상해씨");
		l1.add("Eevee");
		l1.add("13:23");
		l1.add("Muotwo");
		l1.add("1피카츄");
		for(String a : l1) {
			System.out.println(a);
		}

	}

}
