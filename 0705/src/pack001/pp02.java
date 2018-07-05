package pack001;

public class pp02 extends p01 {
	public void call() {
		int time = 132400;
		//위에 지정된 값이 초 단위라 가정하면 몇 시간 몇 분 몇 초인지 출력
		int hour = time/3600;
		int minute = time%3600/60;
		int second = time%60;
		
		
		
		System.out.println(hour+"시간 "+minute+"분 "+second+"초");
		
	}
}
