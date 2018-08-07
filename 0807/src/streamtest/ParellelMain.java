package streamtest;

import java.util.Arrays;
import java.util.stream.Stream;

public class ParellelMain {
	
	public static void aa(String a) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String [] ar = {"아","아","피","곤","하","고","힘","빠","진","다"};
		
		//일반 스트림으로 aa작업
		Stream<String> stm = Arrays.stream(ar);
		long start =System.currentTimeMillis();
		stm.forEach(av->aa(av));
		long end = System.currentTimeMillis();
		System.out.println("일반스트림의 작업시간 : "+ (end-start));
		
		//패러렐 스트림으로 aa작업
		Stream<String> stm1 = Arrays.stream(ar);
		long start1 =System.currentTimeMillis();
		stm1.parallel().forEach(av->aa(av));
		long end1 = System.currentTimeMillis();
		System.out.println("병렬스트림의 작업시간 : "+ (end1-start1));

	}

}
