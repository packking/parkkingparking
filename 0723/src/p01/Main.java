package p01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		BufferedReader bfrd = null;
		try {
			bfrd = new BufferedReader(new FileReader("./access_log.txt"));
			// 접속한 아이피 별 접속횟수 출력
			Map<String, Integer> map = new HashMap();
			// HashMap을 이용해서 접속할 IP 별 트래픽 합계 출력
			Map<String, Integer> trf = new HashMap();
			while (true) {
				String line = bfrd.readLine(); // 버퍼드리더에서 읽어들임
				// 읽은 데이터가 없으면 종료
				if (line == null) {
					break;
				}
				// 공백 기준으로 분할작업
				// System.out.println(line);
				String[] ar = line.split(" ");
				Integer cnt2 = map.get(ar[0]);
				Integer tcnt = trf.get(ar[0]);
				if (cnt2 == null) {
					map.put(ar[0], 1);
				} else {
					map.put(ar[0], cnt2 + 1);
				}
				if (tcnt == null) {
					if (!ar[9].equals("\"-\"") && !ar[9].equals("-")) {
						trf.put(ar[0], Integer.parseInt(ar[9]));
					}
				} else {
					if (!ar[9].equals("\"-\"") && !ar[9].equals("-")) {
						trf.put(ar[0], tcnt + Integer.parseInt(ar[9]));
					}
				}
			}
			// 아이피별 접속 횟수 출력
			Set<String> keyset = map.keySet(); // 중복처리 카운트
			for (String k : keyset) {
				System.out.println(k + "  :  " + map.get(k));
			}
			System.out.println("====================================");
			// 트래픽별
			keyset = trf.keySet();
			for (String k : keyset) {
				System.out.println(k + "  :  " + trf.get(k));
			}
		} catch (Exception e) {
			System.out.println("에러 발생!!" + e.getMessage());
		} finally {
			if (bfrd != null)
				try {
					bfrd.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}