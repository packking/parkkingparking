package pack01;

import java.util.Scanner;

public class test02 {

	public static void main(String[] args) {
		Scanner ss = new Scanner(System.in);
		try {
			int a, b;

			System.out.println("문자 입력");
			String acgtSequence = ss.nextLine();

			int size = acgtSequence.length();

			for (a = 0; a < size; a++) {
				char aa = acgtSequence.charAt(a);
				if (!('A' <= aa && aa <= 'Z')) {
					ss.close();
					System.err.println("영어 대문자를 입력하지 않으셨기에 작업중단");
					break;
				}
			}
			System.out.println("문자 입력");
			String Codon = ss.nextLine();
			int size2 = Codon.length();
			for (b = 0; b < size2; b++) {
				char bb = Codon.charAt(b);
				if (!('A' <= bb && bb <= 'Z')) {
					ss.close();
					System.err.println("영어 대문자를 입력하지 않으셨기에 작업중단");

					break;
				}
			}
			test02 sch = new test02();
			sch.findCodon(acgtSequence, Codon);
		} catch (Exception e) {
			ss.close();
			System.err.println("이상현상으로 인해서 작업을 중단합니다.");

		}

	}

	void findCodon(String acgtSequence, String Codon) {
		int a, b;

		int size = acgtSequence.length();
		int size2 = Codon.length();

		char ar[] = new char[size];
		char vr[] = new char[size2];
		int gg = ((-1) * size2), count = 0;//gg = 초반 검색 관련, count = assassa,assa = 1 만 취급하고, 4는 취급 안하게 해주려고
		for (a = 0; a < size; a++) {
			ar[a] = acgtSequence.charAt(a); // 번호에 해당되는 문자를 한 글자식 가져오는 역할
		}
		for (b = 0; b < size2; b++) {
			vr[b] = Codon.charAt(b); // 번호에 해당되는 문자를 한 글자식 가져오는 역할

		}
		for (a = 0; a < (size - size2) + 1; a++) {	//acgtSequence을 Codon으로 비교탐색
			for (b = 0; b < size2; b++) {
				if (ar[(a + b)] == vr[b]) {
					count = count + 1;			//글자 하나씩 탐색 후에 Codon이랑 일치한 부분마다 +1씩 카운트 누적
				}
			}
			if (count == (size2) && (a + 1) - gg >= size2) {	//카운트가 Codon의 문자개수와 일치하면 동일 할 때
				gg = (a + 1);								
				System.out.printf("%d번 문자  ", gg);
			}
			count = 0;
		}
	}
}