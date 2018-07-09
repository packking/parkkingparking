package p01;

import java.util.Arrays;

public class s01 {
	private int num;
	private String name;
	private String[] hobi;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getHobi() {
		return hobi;
	}

	public void setHob(String[] hobi) {
		this.hobi = hobi;
	}
	//인스턴스 변수의 값을 바르게 확인하기 위한 (디버깅) 메소드
	@Override
	public String toString() {
		return "s01 [num=" + num + ", name=" + name + ", hobi=" + Arrays.toString(hobi) + "]";
	}
	
	//현재 인스턴스를 이용해서 새로운 인스턴스를 만들어주는 메소드
	public s01 clone() {
		s01 user = new s01();
		user.num = this.num;
		user.name = this.name;
		user.hobi = new String[this.hobi.length];
		for(int b=0;b<this.hobi.length;b++) {
			user.hobi[b] = this.hobi[b];
		}
		return user;
	}
}



