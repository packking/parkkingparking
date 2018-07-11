package pack01;

import java.util.*;

public class Main7 {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("Number", "004");
		map.put("Spicy", "파이리");
		map.put("Type", "Fire");
		//동일 키로 다시 저장하면 업데이트 됨 
		map.put("Type","Fire&null");
		//종 키의 값으로 출력
		System.out.println(map.get("Spicy"));
		//타입 키의 값으로 출력
		System.out.println(map.get("Type"));
		//모든 데이터 출력	-	 저장할 때 사용한 key를 몰라도 조회 가능
		Set<String>keys = map.keySet();
		for(String aa : keys) {
//			System.out.println(aa);	//키 값만 출력
			System.out.println(aa + " : "+map.get(aa));	//키 값과 value값 같이 출력
		}


	}

}
