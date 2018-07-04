package pack001;

//p01 를 상속받은 Manager클래스
public class pp01 extends p01 {
	//이런 식으로 생성자를 직접 만들어서 상위 클래스의 생성자를 부르는 경우는 주로 안드로이드에서 많이 발생함
	public pp01() {
		super(10);
	}
	
	private String task;

	public String getTask() {
		return task;
	}
	//메소드 원형 : setTask(String)
	public void setTask(String task) {
		this.task = task;
	}
	@Override
	public String toString() {
		return "pp01 [task=" + task + "] "+super.toString();	//상위클래스인 p01의 toString()도 같이
	}


}
