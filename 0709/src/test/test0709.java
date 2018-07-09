package test;

public class test0709 {

	public static void main(String[] args) {	
//		for(int a=0;a<5;a++) {				//4방분면
//			for(int b=5-a;b>=1;b--) {
//		System.out.print("*");
//		}
//			System.out.println("");
//	}
//		for(int a=0;a<5;a++) {				//1방분면
//			for(int b=0;b<a+1;b++) {
//		System.out.print("*");
//		}
//			System.out.println("");
//	}
		for (int a = 0; a < 5; a++) { // 1방분면
			if (a < 2) {
				for (int b = 0; b < a + 1; b++) {
					System.out.print("*");
				}
			} 
			else {
				for (int b = 0; b < 5 - a; b++) {
					System.out.print("*");
				}
			}
			System.out.println("");
		}
		
	}

}
