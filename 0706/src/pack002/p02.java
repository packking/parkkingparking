package pack002;

public class  p02 {
	public static void main(String[] args) {
		int []ar = {10,20,53,34,55};
		int []br = new int[5];	//배열 5개 선언
		int b,c,aa=0,min=50;
		
		//배열 안의 숫자들 중에서 50과 가장 가까운 수 표현
//		for(int a=0;a<5;a++) {			//배열 안의 수들 1개씩 전부 출력
//			System.out.println(ar[a]);
//		}
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
