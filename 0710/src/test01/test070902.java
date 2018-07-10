package test01;

public class test070902 {

	public static void main(String[] args) {
		int a, b, n = 7;
		String ar[][] = new String[n][n];
		String br[][] = new String[n][(n-1)+1];
		for (a = 0; a < n; a++) {	//ar배열
			if (a < (n / 2)) {
				for (b = 0; b < (n - a) - 1; b++) {
					ar[a][b]="*";
				}
			} 
			else {
				for (b = 0; b < a; b++) {
					ar[a][b]="*";
				}
			}
		}
		for(a=0;a<(n/2)+1;a++) {			//br배열
			for(b=0;b<n-(2*a);b++) {
				br[a][b]="*";
			}
		}
		
		
		for(a=0;a<n;a++) {
			for(b=0;b<n;b++) {
				if(br[a][b]!="*") {br[a][b]=" ";}
				System.out.print(br[a][b]);
			}
			System.out.println("");
		}
		System.out.println("");
		
		
		for(a=0;a<n;a++) {
			for(b=0;b<n;b++) {
				if(ar[a][b]!="*") {ar[a][b]=" ";}
				System.out.print(ar[a][b]);
			}
			System.out.println("");
		}

	}

}
