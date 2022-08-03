package homework;

import java.util.Scanner;

public class Solution_D2_1954_유환규 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
		StringBuilder sb = new StringBuilder(50);
		for(int i=1;i<=T;i++) {
			int n = sc.nextInt();
			int x = 0;
			int y = -1;
			int start = 1;
			int map[][] = new int[n][n];
			for(int j=n;j>0;j-=2) {
				//동
				for(int k=0;k<j;k++) {
					x+=dir[0][0];
					y+=dir[0][1];
					
					map[x][y] = start++;
				}
				//북
				for(int k=0;k<j-1;k++) {
					x+=dir[1][0];
					y+=dir[1][1];
					map[x][y] = start++;
				}
				//서
				for(int k=0;k<j-1;k++) {
					x+=dir[2][0];
					y+=dir[2][1];
					map[x][y] = start++;
				}
				//남
				for(int k=0;k<j-2;k++) {
					x+=dir[3][0];
					y+=dir[3][1];
					map[x][y] = start++;
				}
			
			}
			
			sb.append("#");
			sb.append(i);
			sb.append("\n");
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					sb.append(map[j][k]+" ");
				}
				
				sb.append("\n");
				
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
