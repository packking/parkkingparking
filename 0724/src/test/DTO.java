package test;

import java.text.SimpleDateFormat;
import java.sql.Date;

public class DTO {
	private int num;
	private String name;
	private int result;
	private Date birthDate;
	
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
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "IT팀 사원정보 {사원번호 : " + num + ", 성함 : " + name  + ", 생년월일 : " + birthDate + ", 성과점수 : " + result + "}";
	}
	

	
}

