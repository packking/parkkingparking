package pack003;

public class p01 {
	public static void main(String[] args) {
		try{//문자열 배열 생성
		String [] ar = {"아침","점심","저녁"};
		
		//배열의 데이터를 순회하면서 출력
		int size = ar.length;
		
		for(int a = 0; a<= size;a++){
			System.out.println(ar[a]);
			if(a>1) {
				throw new NumberFormatException("강제 예외 발생");
			}
		}
		}catch(ArrayIndexOutOfBoundsException e) {	//예외 관련으로 사용하는 메소드 aa     bb처럼 쓰는 이유는 발생한 예외가 어떤 것인지 구체적으로 표현하기 위해서
			//예외 내용 출력
			System.out.println(e.getMessage());
			//예외 내용 추적
			e.printStackTrace();
		}catch(Exception e) {	//예외 관련으로 사용하는 메소드 bb ->aa와 bb의 순서가 바뀌면 aa의 코드가 필요없어지고 죽어버린 데드코드가 되어서 실행이 안됨
			//예외 내용 출력
			System.out.println(e.getMessage());
			//예외 내용 추적
			e.printStackTrace();
		}
		finally {
			System.out.println("예외 발생 여부 관계없이 출력");
		}
	}
	

}
