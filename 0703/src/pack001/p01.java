package pack001;

public class p01 {

	private String id;

	// id의 getter
	public String getId() {
		return id;
	}

	// id의 setter
	public void setId(String arg) { // set은 리턴타입이 void
		id = arg;
	}

	private String pw;

	public String getPw() {
		return pw;
	}

	public void setPw(String arg) {
		pw = arg;
	}

	private String cname;
	private int age;
	private String gender;
	private String pnum;

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	// 인스턴스 변수들을 출력해주는 메소드
	// 클래스 안에서 클래스에 만들어진 변수를 사용할 때는 인스턴스나 클래스 이름을 기재하지 않음
	public void pp() {
		System.out.println("ID		:	" + id + "\n" + "Password	:	" + pw + "\n" + "캐릭터명	:	" + cname + "\n"
				+ "나이		:	" + age + "\n" + "성별		:	" + gender + "\n" + "전화번호	:	" + pnum);
	}

	@Override
	public String toString() {
		return "p01 [id=" + id + ", pw=" + pw + ", cname=" + cname + ", age=" + age + ", gender=" + gender + ", pnum="
				+ pnum + "]";
	}
	//가변매개변수(VARARGS)   매개변수를 개수에 상관없이 입력하게 해주는...
	public static int sum(int ... ar) {	//static메소드 : 클래스명칭 으로 호출 가능하게 해주는 메소드
		int tot = 0;					//매개변수에 ... 있으면 매개변수 개수에 상관없이 대입가능
		// heap에 있는 데이터를 스택에 저장
		// 자주 사용하기에 heap에 있으면 효율 저하됨
		int len = ar.length;//반복문을 사용하기에 len변수로 대용
		for (int i = 0; i < len; i++) {
			tot = ar[i];
		}
		return tot;
	}

}
