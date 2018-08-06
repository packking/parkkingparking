package streamtest;

import java.util.*;
import java.util.stream.*;

public class StreamMain02 {

	public static void main(String[] args) {
		String [] rainbow = {"빨강","주황","노랑","초록","파랑","파랑","군청","연노랑","보라"};
		Stream<String>stm = Arrays.stream(rainbow);	//스트림 변환
//		stm.forEach(color->{System.out.println(color);});		//모든 데이터 출력
		stm.distinct().forEach(color->{System.out.print(color);});	//distinct()를 사용해서 중복 제거
		
		System.out.println("");
		
		stm = Arrays.stream(rainbow);	//1회 사용 이후에 다시 사용하려면 새로이 선언해야 함
		//Stream의 중간처리메소드는 여러 개 동시 사용 가능	->중복 제거하고,앞에서 2개 건너뛴 후에 3개만 가져오는 forEach 실행
		//stm.distinct().skip(2).limit(3).forEach(color->{System.out.print(color);});
		//return 문장 하나 밖에 없을 때는 return 이라는 단어를 생략 가능->수행되는 코드가 한 줄 일때는 {}생략 가능
		//필터링	-	"랑" 으로 끝나면서 두 글자가 아닌 데이터 출력
		stm.distinct().filter( color->color.endsWith("랑") ).filter(color->color.length()!=2).forEach(color->System.out.print(color));
		
		
	}

}
