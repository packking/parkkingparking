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
		int cnt = ((-1) * size2), gg = 0;

		for (a = 0; a < size; a++) {
			ar[a] = acgtSequence.charAt(a); // 번호에 해당되는 문자를 한 글자식 가져오는 역할
		}
		for (b = 0; b < size2; b++) {
			vr[b] = Codon.charAt(b); // 번호에 해당되는 문자를 한 글자식 가져오는 역할

		}
		for (a = 0; a < (size - size2) + 1; a++) {
			for (b = 0; b < size2; b++) {
				if (ar[(a + b)] == vr[b]) {
					gg = gg + 1;
				}
			}
			if (gg == (size2) && (a + 1) - cnt >= size2) {
				cnt = (a + 1);
				System.out.printf("%d번 문자  ", cnt);
			}
			gg = 0;
		}
	}
}