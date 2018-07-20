package bytestream;

import java.io.*;

public class BufferedIOStream {

	public static void main(String[] args) {
		// 파일에서 바이트 단위로 버퍼링을 이용해서 읽기
		BufferedInputStream bi01 = null;
		try {
			bi01 = new BufferedInputStream(new FileInputStream("./0720test.txt"));
			while (true) {
				byte[] b01 = new byte[3];
				int aa = bi01.read(b01);
				// System.out.println(b01); //배열은 toString이 재정의 되지 않았기에 해시코드가 출력됨
				// for(byte ex : b01) { //코드를 각각 출력
				// System.out.println(ex);
				// }
				System.out.println(new String(b01)); // 문자열로 변환
				if (aa <= 0) {
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("에러 발생 : " + e.getMessage());
		}finally {
			if (bi01 != null)		//bi01을 읽었을 때
			try {
					bi01.close();	//종료
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
