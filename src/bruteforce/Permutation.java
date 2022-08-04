package bruteforce;

import java.util.Scanner;

public class Permutation {
	static int N = 0;
	static int M = 0;
	static int arr[];
	static int ans[];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		visit = new boolean[N];
		ans = new int[M];
		
		for(int i = 0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		perm_Recursive();
		
	}
	
	
	public static void perm_Recursive() {
		
//		perm(0);
		perm_mask(0,0);
		System.out.println(sb.toString());
	}
	
	
	public static void perm(int num) {
		if(num == M) {
			
			for(int i=0;i<M;i++) {
				sb.append(ans[i]);
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0;i<N;i++) {
			if(!visit[i]) {
				visit[i] = true;
				ans[num] = arr[i];
				perm(num+1);
				visit[i] = false;
			}
		}
	}
	
	
	public static void perm_mask(int num,int mask) {
		if(num == M) {
			
			for(int i=0;i<M;i++) {
				sb.append(ans[i]);
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0;i<N;i++) {
			if((mask & 1<<i) != 0) continue;
			
			ans[num] = arr[i];
			perm_mask(num+1,mask | (1<<i));
			 
		}
	}
	
}
