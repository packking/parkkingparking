package datastructure;

import java.util.HashMap;

public class MapMain3 {

	public static void main(String[] args) {
		//프로야구 팀 별 선수 명단을 배열로 만들기
		String [] kia = {"윤석민", "안치홍", "김선빈"};
		String [] hanhwa = {"권혁", "정근우"};
		String [] lotte = {"레일리", "이대호"};
		//String [] nc = {"박석민", "이재학"};
		
		//동일한 의미를 갖는 배열들을 묶을 때 바로 배열이나 리스트로 묶는 것은
		//바람직하지 않습니다.
		//배열이나 리스트는 인덱스를 가지고 구분을 하기 때문에 의미를 부여하지
		//못합니다.
		//배열이나 리스트를 다시 배열이나 리스트로 묶을 때는 먼저 Map으로
		//의미를 부여해서 묶은 다음 다시 배열이나 리스트로 묶으라고 합니다.
		
		HashMap<String, Object> map1 = 
				new HashMap<>();
		map1.put("team", "기아");
		map1.put("data", kia);
		
		HashMap<String, Object> map2 = 
				new HashMap<>();
		map2.put("team", "한화");
		map2.put("data", hanhwa);
		
		HashMap<String, Object> map3 = 
				new HashMap<>();
		map3.put("team", "롯데");
		map3.put("data", lotte);
		
		String [] nc = {"박석민", "이재학"};
		HashMap<String, Object>map4 = new HashMap<>();
		map4.put("team", "nc");
		map4.put("data", nc);
		//HashMap의 배열
		HashMap [] players = {map1, map2, map3, map4};
		
		for(int i=0; i<players.length; i=i+1) {
			HashMap temp = players[i];
			//팀 이름 출력
			System.out.print(temp.get("team")+":" + "\t");
			//선수 명단 가져오기
			//출력을 할 때는 get 한 데이터를 형변환하지 않지만
			//저장을 하거나 사용을 할 때는 원래의 자료형으로 강제 형 변환을
			//해서 사용합니다.
			String [] imsi = (String [])temp.get("data");
			for(int j=0; j<imsi.length; j=j+1) {
				System.out.print(imsi[j] + "\t");
			}
			System.out.println("");
		}

	}

}