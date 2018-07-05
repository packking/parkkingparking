package pack001;
//p02 인터페이스를 임플리먼츠 한 클래스를 생성
//하나의 인터페이스를 임플리먼츠 한 클래스의 이름은 인터페이스 이름 뒤에 Impl 붙이는 것이 관례

public class inter01 implements p02 {// implements 는 다중으로 연결 가능

	@Override
	public boolean idcheak(String id) {
		boolean result = false;
		//id가 root가 아니라면 true
		if(id.equals("root")==false) {
			result = true;
		}
		return result;
	}

	@Override
	public int login(String id, String password) {
		//id가 root이고, password가 1234이면 로그인 성공 0 , password가 틀리면 비밀번호 틀렸습니다. 1 , id만 틀리면 해당 id는 존재하지 않습니다. 2  둘 다 틀리면  둘 다 해당 안됩니다.  3
		int pass=3;
		if(id.equals("root")) {
			if(password.equals("1234")) {
				pass=0;
			}
			else {
				pass = 1;
			}
		}
		else if(password.equals("1234")){pass=2;}

		
		return pass;
	}
	
}
