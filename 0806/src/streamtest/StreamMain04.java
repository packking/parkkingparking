package streamtest;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMain04 {

	public static void main(String[] args) {
		int [] ar = {10,20,50,40,41};
		IntStream stmint = Arrays.stream(ar);	//정수형 스트림
		stmint.sorted().forEach(s->System.out.printf("%d \t",s));
		
		System.out.println("");
		
		String [] name = {"배진아","황수정","이현아","신지현"};
		Stream<String> stmname = Arrays.stream(name);	//문자열 스트림
		stmname.sorted().forEach(s->System.out.printf("%s \t",s));	//정렬은 기본적으로 sorted((a,b)->a.compareTo(b))
		
		System.out.println("");
		
		Stream<String> stmname1 = Arrays.stream(name);	//문자열 스트림
		stmname1.sorted((a,b)->b.compareTo(a)).forEach(s1->System.out.printf("%s \t",s1));	//역순정렬
	}

}
