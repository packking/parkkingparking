import java.util.Arrays;

public class p04 {

	public static void main(String[] args) {
		// 문자열 배열 생성
		String[] subject = { "Java", "Oracle", "Web Front End",
				"Web Back End - Java", "Android", "iOS" };
		//subject 정렬	//알파벳 순->대소문자 순
		Arrays.sort(subject);
		//배열의 데이터 전부 출력
		/*
		for(int i=0; i<subject.length; i=i+1) {
			System.out.println(subject[i]);
		}
		*/
		for(String temp : subject) {
			System.out.println(temp);
		}
		
		// Oracle의 위치 검색
		int idx = Arrays.binarySearch(subject, "Oracle");
		System.out.println(idx);
		//Android의 위치 검색
		idx = Arrays.binarySearch(subject, "Android");
		System.out.println(idx);
		
		
		
	}
}
