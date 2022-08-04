package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class Combination {
	static int N;
	static int M;
	static int arr[];
	static int res[];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		res = new int[M];
		arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		comb();
	}
	
	public static void comb() {
		comb_dfs(0,0);
	}
	
	public static void comb_dfs(int cnt,int index) {
		if(cnt == M) {
			System.out.println(Arrays.toString(res));
			return;
		}
		
		for(int i=index;i<N;i++) {
			res[cnt] = arr[i];
			comb_dfs(cnt+1,i+1);
		}
		
		
	}
	
}
