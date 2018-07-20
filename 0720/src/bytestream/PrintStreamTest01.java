package bytestream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
public class PrintStreamTest01 {

	public static void main(String[] args) throws IOException {
		PrintStream ps01 = null;
		try {
			ps01 = new PrintStream(new FileOutputStream("./0720test.txt"));
			ps01.println("asasdasdd");
			ps01.println("qweasdasd");
			ps01.flush();
			
		} catch (Exception e) {
			System.err.println("파일쓰기 에러 발생!! " + e.getMessage());
		} finally {
			if (ps01 != null)
				ps01.close();
		}
	}

}