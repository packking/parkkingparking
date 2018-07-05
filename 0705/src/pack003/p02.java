package pack003;

public class p02 {
	public double latitude;
	public double longitude;
	
	
		//매개변수가 없는 생성자  - 디폴트 생성자
	public p02() {
		super();
		// TODO Auto-generated constructor stub
	}
	//접근자 메소드 - getter , setter
	public double getLatitude() {
		return latitude;
	}



	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}



	public double getLongitude() {
		return longitude;
	}



	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public p02(double latitude, double longitude) {		//p01에다 데이타 공유 목적
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}



	//지도 출력 메소드
	public void showMap() {
		System.out.println("위도 : "+latitude+" 경도 : "+longitude+" 위치의 지도를 출력합니다.");
	}
}
