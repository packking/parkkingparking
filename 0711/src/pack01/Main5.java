package pack01;

import java.util.*;

public class Main5 {

	public static void main(String[] args) {
		Stack <String> st = new Stack<>();
		st.push("파이리");
		st.push("리자드");
		st.push("리자몽");
		st.push("꼬부기");
		st.push("어니부기");
		st.push("거북왕");
		
		//데이터가 역순으로 리턴됨 -제거되면서
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st);		//제거 확인
		
		PriorityQueue <String> q = new PriorityQueue<>();
		
		q.add("피카츄");
		q.add("라이츄");
		q.add("1이브이");
		
		System.out.println(q);	//크기 순으로 리턴	->작은 순부터->숫자 대문자 소문자 특문
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q);
	}

}
