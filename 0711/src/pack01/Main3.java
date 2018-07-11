package pack01;
import java.util.*;


public class Main3 {

	public static void main(String[] args) {
		// 정수 List 와 문자 List의 정렬
		ArrayList<Integer>a1 = new ArrayList<>();
		
		a1.add(40);
		a1.add(32);
		a1.add(35);
		
		Comparator<Integer> comp = new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				Integer first = (Integer) o1;
				Integer second = (Integer) o2;
				return first - second;
			}
		};
		a1.sort(comp);
		System.out.println(a1);
		
		LinkedList<String>l1 = new LinkedList();
		l1.add("파이리");
		l1.add("꼬부기");
		l1.add("이상해씨");
		
		Comparator<String> comp1 = new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				String first = (String)o1;
				String second = (String)o2;
				return second.compareTo(first);
			}
			};
			l1.sort(comp1);
			System.out.println(l1);

	}

}
