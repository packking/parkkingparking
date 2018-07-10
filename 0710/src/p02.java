
public class p02 {

	public static void main(String[] args) {
		String [] station = {"광화문","종로3가","을지로4가"};	//station:3000번지-. 3000번지 내부에는 광화문,종로3가,을지로4가의 주소,길이(3)가 들었음
		for(int a=0;a<station.length;a++) {
			System.out.println(station[a]);
		}
		
		for(String t : station) {		//위와 결과 같음 -> 광화문 도착 ->대기->종로3가로 ->도착->대기->을지로4가로->도착 ->대기->끝
										//순차적 작업, 뒤로 되돌아오는 작업은 못함
			System.out.println(t);		//for(임시변수 : 데이터의 모임){ 내용 } - for-each 
		}
	}
	

}
