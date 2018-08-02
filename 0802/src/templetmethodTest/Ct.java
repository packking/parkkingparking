package templetmethodTest;

import java.sql.Date;

public class Ct {
	private int num;
	private String name;
	private String pnum;
	private String address;
	private Date birthday;
	
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
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "TestingClass [num=" + num + ", name=" + name + ", pnum=" + pnum + ", address=" + address + ", birthday="
				+ birthday + "]";
	}
	
	
}
