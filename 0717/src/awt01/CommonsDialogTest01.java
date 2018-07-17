package awt01;

import java.awt.*;

public class CommonsDialogTest01 extends Frame{
	public CommonsDialogTest01() {
		setBounds(200,200,500,500);//위치,크기 설정
		setTitle("공용 대화상자");//타이틀
		
		FileDialog fdt01 = new FileDialog(this,"파일 가져오기");
		fdt01.setDirectory("C:\\Users\\503-15\\Pictures\\Saved Pictures");	//시작 장소
		fdt01.setVisible(true);
		
		String aa = fdt01.getDirectory() + fdt01.getFile();	//선택한 폴더와 파일이름 가져오기
		
		Label lbt01 = new Label(aa);	//선택한 폴더와 파일이름을 나타내는 라벨
		add(lbt01);	//프레임에 라벨 추가
		
		setVisible(true);	//화면출력여부
		
	}
}
