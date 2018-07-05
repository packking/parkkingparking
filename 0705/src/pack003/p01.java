package pack003;

public class p01 {
	public double latitude;
	public double longitude;

 
	
	public void getLocation() {
		//p02 map = new p02(latitude, longitude);		//생성자를 이용한 데이터 전달
		
		//setter를 이용한 데이터 전달
		p02 map = new p02();
		map.setLatitude(latitude);
		map.setLongitude(longitude);
		
		map.showMap();
	}
}
