package streamtest;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMain03 {

	public static void main(String[] args) {
//		Student std = new Student();
//		std.setName("신지현");
//		std.setGender("여성");
//		std.setScore(92);
//		std.setSubject("영어영문학");
//		std.setAge(27);
//		
//		Student std1 = new Student("신지현","여성",92,"영어영문학",27);
//		
//		System.out.println(std);
//		System.out.println(std1);
		
		//Student 클래스 인스턴스의 배열
		Student [] sr = new Student[4];
					//=[null,null,null,null,null]	->기본형은 0, 참조형은 null	-> 안쓰는 곳에 값을 주지 않으면  null 관련 에러 발생함
		sr[0] = new Student("신지현","여성",92,"영어영문",27);	//입력 순서를 반드시 지켜야함
		sr[1] = new Student("이현아","여성",92,"정치경제",26);
		sr[2] = new Student("배진아","여성",92,"현대미술",28);
		sr[3] = new Student("황수정","여성",92,"일어일문",25);
		
		Stream<Student>stm = Arrays.stream(sr);		//정치경제 학과가 아니며 28살 미만의 학생들의 자료들만 출력
		stm.filter(date->date.getSubject().equals("정치경제")==false && date.getAge()<28).forEach(date->{System.out.println(date);});
		
		Stream<Student>stm1 = Arrays.stream(sr);	//Student를 이름으로 변경해서 이름만 출력하게 끔
		stm1.map(Student::getName)	//정수는 mapToInt, 실수는  mapToDouble
		.sorted((a,b)->b.compareTo(a)).forEach(date->{System.out.printf("%s \t",date);});
		
		System.out.println("");
		
		Stream<Student>stm2 = Arrays.stream(sr);	//이름 순으로 내림차순	기본적으로 기준이 있으면 오름차순
		stm2.sorted((a,b)->b.getName().compareTo(a.getName())).forEach(date->{System.out.println(date);});

	}

}
