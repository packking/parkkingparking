package characterstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main1 {

	public static void main(String[] args) {


		
		BufferedReader bfrd = null;
		try {
			//키보드로부터 입력받을 수 있는 인스턴스 생성
			bfrd = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("이름 : ");
			String name = bfrd.readLine();
			System.out.println("나이 : ");
			String age = bfrd.readLine();
			System.out.println("키 : ");
			String height = bfrd.readLine();
			//3가지 데이터 하나로 저장하기 위한 인스턴스 생성
			Member mb = new Member();
			mb.setName(name);							//출력할 때는 VO클래스나 Map이나 별반 차이는 없지만, 사용할 때는 다름
			mb.setAge(Integer.parseInt(age)); 		   //문자형에서 정수형으로 형 변환
			mb.setHeight(Double.parseDouble(height));  //문자형에서 실수형으로 형 변환
			

			//맵을 이용해서 저장
			Map<String,Object> map = new HashMap<>();
			map.put("name", name);
			map.put("age", age);
			map.put("height", height);
			
			System.out.println(mb);
			System.out.println(map);
			
			//나이를 1씩 저장
			int r = mb.getAge()+1;
			//Map에서는 데이터를 가져와서 사용할 때는 반드시 강제 형 변환을 해야함
			r = (Integer)map.get("age")+1;		
			
		}catch(Exception e){
			System.out.println("에러 발생!!"+e.getMessage());
		}finally {
			if(bfrd!=null) 
				try{
					bfrd.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
		}

	}

}
