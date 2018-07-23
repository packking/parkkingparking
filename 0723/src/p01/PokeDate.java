package p01;

import java.io.Serializable;

public class PokeDate implements Serializable {//Serializable 인터페이스를 구현한 객체 단위로 데이터를 전송하게 되면, 
												//그 클래스가 없으면 데이터 읽을 수 없음
	private int num;
	private String name;
	private String type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "PokeDate [num=" + num + ", name=" + name + ", type=" + type + "]";
	}



}
