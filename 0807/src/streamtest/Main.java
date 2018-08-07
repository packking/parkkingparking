package streamtest;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		List<StudentVO> list = dao.fetch();
		//System.out.println(list);
		
//		for(StudentVO date : list) {	//출력하는 메소드의 인스턴스 이름을 대입하면 toString의 결과를 출력
//			System.out.println(date);
//		}
		
//		Stream<StudentVO> stm = list.stream();	//문자열 스트림
////		stm.filter(s->s.getGender().equals("남자")==false).limit(3)
////		.sorted((a,b)->b.getNum().compareTo(a.getNum())).forEach(s->System.out.printf("%s \n",s));
//		stm.filter(s->s.getGender().equals("남자")==false).limit(3)
//		.sorted((a,b)->b.getScore()-a.getScore()).forEach(s->System.out.printf("%s \n",s));
		//숫자는 서로간에 -	,	 문자나 날짜류 데이터는  .compareTo() 사용
		Stream<StudentVO> stm1 = list.stream();
//		Long count1= stm1.filter(s->s.getGender().equals("남자")==false).limit(3).count();
//		System.out.println("검색조건에 해당하는 데이터는 "+count1+"개 입니다.");
		
		//Optional 로 리턴되는 데이터는 한 번 더 가공작업을 해야함
//		StudentVO vo = stm1.findFirst().get();
//		System.out.println(vo);
		
		//score 합계 구하기
		//숫자데이터가 아니면 바로 합계를 구할 수 없기에 Map 메소드를 사용해서 숫자데이터로 변경한 후에 합계를 구해야함
//		int sum = stm1.mapToInt(StudentVO::getScore).sum();
//		System.out.println(sum);
		
		//age 평균 구하기
//		Double avg = stm1.mapToInt(StudentVO::getAge).average().getAsDouble();
//		System.out.println(avg);
		
		//성별이 여자인 데이터의 평균 나이를 구하는데 소수 첫째자리에서 반올림해서 정수부분만 출력
//		Double avg = stm1.filter(s->s.getGender().equals("여자")).mapToInt(StudentVO::getAge)
//				.average().getAsDouble();
//		int ageavg=(int)(avg+0.5);	//반올림 하고 정수로 변환시킴 ->이  후의 소숫점은 제외됨
//		System.out.printf("%s",ageavg);
		
		//성별이 여자 인 데이터만 가지고 List 생성
//		List<StudentVO> wlist = stm1.filter(s->s.getGender().equals("여자")).collect(Collectors.toList());
//		for(StudentVO w : wlist ) {
//			System.out.println(w);
//		}
		
		
		//이름과 점수만을 갖는 Map - 1
//		Map<String,Integer> map = stm1.collect(Collectors.toMap(StudentVO::getName,StudentVO::getScore));
//		System.out.println(map);
		//이름과 점수만을 갖는 Map - 2
//		Map<String,Integer> map = stm1.collect(Collectors.toMap(StudentVO::getName,v->v.getScore()));
//		System.out.println(map);		

		
		//성별 = 여자, 점수 >=90 인 데이터 create List
//		List<StudentVO> wlist = stm1.filter(s->s.getGender().equals("여자")&& s.getScore()>=90)
//				.collect(Collectors.toList());
//		for(StudentVO w : wlist ) {
//			System.out.println(w);
//		}
		
		//여기서의 String는 getGender 자료형	
		//Map<그룹화 시킬 기준의 자료형,원본 데이터가 저장된 자료구조>
//		Map<String,List<StudentVO>> map =
//		stm1.collect(Collectors.groupingBy(StudentVO::getGender));
//		System.out.println(map);
		
		Map<String,Integer> map =
		stm1.collect(Collectors.groupingBy(
				StudentVO::getGender,Collectors.summingInt(StudentVO::getScore)));
		//System.out.println(map);
		Set<String> keySet = map.keySet();
		for(String k : keySet) {
			System.out.println(k + " : " + map.get(k) );
		}
		
	}
}
