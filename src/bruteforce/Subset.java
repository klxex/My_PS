package bruteforce;

import java.util.Scanner;

public class Subset {
	
	static int N;
	static int arr[];
	static boolean selected[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		selected = new boolean[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		subset_bitmask();
		
	}
	
	public static void subset_bitmask() {
		
		for(int i=0,len=1<<N;i<len;i++) {
			for(int j=0;j<N;j++) {
				if((i & 1<<j) != 0 ) {
					System.out.print(arr[j]+" ");
				}
			}
			System.out.println();
		}
		
	
	}
	
	
}
