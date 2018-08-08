package smtp;

import org.apache.commons.mail.SimpleEmail;

public class SMTPText01 {

	public static void main(String[] args) {
		try {
			//텍스트 파일을 보낼 수 있는 클래스의 객체 생성
			SimpleEmail email = new SimpleEmail();
			
			//서버 설정
			email.setAuthentication("아이디", "비밀번호");	//메일 전송시킬 아이디와 그 아이디의 비밀번호
			email.setHostName("smtp.naver.com");
			email.setSmtpPort(587);		//포트번호 입력
			email.setTLS(true);			//수신 여부
			email.setSSL(true);			//송신 여부
			email.setFrom("benibararen@naver.com","관리자");
			email.setCharset("utf-8"); 		// 문자 인코딩 설정
			
			//수신측 설정
			email.addTo("메일주소1");	//받는 쪽은 1개씩 따로 추가
			email.addTo("메일주소2");
			email.setSubject("메일 보내기 연습");
			email.setMsg("asdfasdf");		//메일 내용
			
			//전송 관련
			email.send();	//이메일 전송
			System.out.println("메일 보내기 성공");
		}catch(Exception e){
			System.err.println(e.getMessage());
			e.printStackTrace();
			}

	}

}
