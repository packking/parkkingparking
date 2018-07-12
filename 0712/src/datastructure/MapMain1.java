package datastructure;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

public class MapMain1 {

	public static void main(String[] args) {
		//이름과 나이 및 소속 회사를 저장하는 Map을 생성
		//HashMap은 key의 순서를 알 수 없음
		//HashMap<String, Object> map = new HashMap<>();
		
		//입력한 순서대로 key를 저장합니다.
		/*
		LinkedHashMap<String, Object> map = 
				new LinkedHashMap<>();
		*/
		TreeMap<String, Object> map = new TreeMap<>();
		map.put("이름", "아이린");
		map.put("age", 28);
		map.put("company","SM");
		
		//전체를 한꺼번에 출력 - toString이 재정의 되어 있음
		System.out.println(map);
		//순서에 상관없이 항목별로 출력
		System.out.println("==================");
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(key + ":" + map.get(key));
		}

	}
}