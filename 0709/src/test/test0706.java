package test;

public class test0706 {

	public static void main(String[] args) {
//		//가장 큰 수 출력
//		int []ar = {50, 20, 130, 70, 56,};
//		int a,c,m=0;
//		c=ar.length;
//		for(a=0;a<c;a++) {
//			if(ar[a]>m) {
//				m=ar[a];
//			}
//		}
//		System.out.println("기존에 입력된 숫자 중에서 가장 큰 수 는 "+m+"입니다.");
		
		//50에 가장 가까운 수 찾기
		int []ar = {10,20,53,34,55};
		int []br = new int[ar.length];	//배열 5개 선언
		int aa=0,min=50;
		
		for(int a=0;a<5;a++) {			//배열 안의 수들 1개씩 전부 출력
		if(ar[a]>50) {			//50보다 큰 경우
			br[a]=ar[a]-50;
		}
		else{					//같거나 작은 경우
			br[a]=50-ar[a];
			
		}
		if(min>br[a]) {aa=ar[a];min=br[a];}	//aa= 최소값에 해당되는 수를 집어넣음, min은 50이랑 차이 났던 값 주입 -  매번 비교를 위해 변수 사용
		
	}
	System.out.println(aa);

	}

}
