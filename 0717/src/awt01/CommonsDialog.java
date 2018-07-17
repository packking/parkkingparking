package awt01;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;

public class CommonsDialog extends Frame {
	public CommonsDialog() {
		setBounds(200,200,600,600);
		setTitle("대화상자 확인작업");
		
		FileDialog fd = new FileDialog(this,"파일 대화상자");	//이걸 쓰겠다는 의미의 this
		//디렉토리 설정
		fd.setDirectory("C:\\Users\\503-15\\Documents\\박경태\\mc\\text\\0710");
		//파일 대화상자 화면 출력
		fd.setVisible(true);
		
		//선택한 파일 경로 가져오기
		String path = fd.getDirectory()+fd.getFile();
		//System.out.println(path);
		Label lb1 = new Label(path);
		add(lb1);
		
		setVisible(true);
		
		
	}
}
