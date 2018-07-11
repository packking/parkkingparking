package test01;

public class test0709031 {	//class test070903는 배열로 했기에 여기서는 유사결과를 배열없이 
	public static void main(String[] args) {
		int a, n = 66;		//세로 6칸, 가로 11칸 이기에 6*11인 66
		int e = 0, x = 0, y = 0, cnt = 0,mid=6;
		int c = mid, d = mid;
		
		for (a = 1; a <= n; a++) {
			e = e + 1;	//줄띄움을 위한 카운트 
			if(cnt>=5&&(a%11)>=2||e==66) {System.out.print(" "+y);y=y+1;}	//밑바닥 찍기 a==66 찍지 않으면 밑의 조건문과 중복됨-배열과 달리 충돌되면 출력 안됨
			else if((a%11)==c||(a%11)==d) {System.out.print(" "+x);x=x+1;}	//여기 조건문에 ||a==66를 찍으면  이쪽 결과물 나옴
			else if(c<(a%11)&&d>(a%11)) {System.out.print("#@");}			//삼각형 테두리의 내부 변환
			else{System.out.print("^*");}
			
			if(e%11==0) {	//11배수씩 줄내림 + 사이드 벌리기
				System.out.println("");
				
				if(cnt>=0) {c=(mid-1)-(cnt);d=(mid+1)+(cnt);}
				cnt=cnt+1;
			}
			

		}
	}
}
