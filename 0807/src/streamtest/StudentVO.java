package streamtest;
public class StudentVO {
	
	//테이블의 각 컬럼의 값들을 저장하기 위해서 만듬
	
	private String num;
	private String name;
	private String subject;
	private int score;
	private String gender;
	private int age;
	
	public StudentVO() {		//인스턴스 생성할 때에 데이터를 바로 대입해서 생성하면 메소드 호출횟수를 줄일 수 있기 때문에 생성
		super();				//데이터 없는 것들
								//상위 클래스의 생성자를 호출하는 구문 -> new Object();
	}
	public StudentVO(String num, String name, String subject, int score, String gender, int age) {
		super();				//데이터 있는 것들
		this.num = num;
		this.name = name;
		this.subject = subject;
		this.score = score;
		this.gender = gender;
		this.age = age;
	}
	
	
	//인스턴스 변수가 프라이베이트라서 같은 그룹에서만 입출력 하게끔
	
	//인스턴스 변수를 private으로 생성했기 때문에
	//인스턴스가 사용할 수 없어서 인스턴스 변수를 사용하기 위한 메소드
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override		
	public String toString() {		//데이터를 빠르게 확인하기 위해서 - 디버깅 목적
		return "학생정보 [학번 : " + num + ", 이름 : " + name + ", 학과 : " + subject + ", 성별: "
				+ gender + ", 나이 : " + age + ",점수 : " + score + "]";
	}
	
	
	
	
	
}
