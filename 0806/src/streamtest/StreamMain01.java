package streamtest;

import java.util.*;
import java.util.stream.Stream;

public class StreamMain01 {

	public static void main(String[] args) {
		//배열은 [인덱스]를 통해서 각각의 데이터에 접근
		String [] ar = {"김진수","안호철","홍두식"};
//		for(String x=0;x<ar.length;x++) {
//			System.out.print(ar[x]);
//		}
		for(String x : ar) {
			System.out.print(x);
		}
		System.out.println("");
		//List는 get(인덱스)를 통해서 각각의 데이터에 접근
		List<String> list = new ArrayList<>();
		list.add("강수아");
		list.add("민현지");
		list.add("남현주");
		list.add("임진아");
//		for(int x=0;x<list.size();x++) {
//			System.out.print(list.get(x));
//		}
		for(String x : list) {				//for~each or Iterator
			System.out.print(x);
		}
		
		System.out.println("");
		
		Stream<String>stm = Arrays.stream(ar);		//문자열 배열로 Stream 만들기
		stm.forEach(x2->System.out.print(x2));
		
		System.out.println("");
		
		stm = list.stream();	//List로 Stream 만들기
		stm.forEach(x2->{System.out.print(x2);});
	}

}
