package pack001;

public class pp01 extends p01 {
	public void call() {
		double a = 10.75;
		//소수 첫자리에서 반올림해서 출력
		System.out.println((int)(a+0.5));
		//소수 둘째자리에서 반올림
		System.out.println(((int)((a+0.05)*10))/10.0);	//10으로 하면 형 변환이 됬기에 정수로 되기에 108/10 ->10.8이 아닌 10이 됨
	}
}
