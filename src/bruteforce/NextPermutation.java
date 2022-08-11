package bruteforce;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 
 * Next Permutation
 * - 현재 순열의 상태에서 사전순(오름차순)으로 나열했을 때 다음 단계의 순열을 생성
 * - 최종 목표 가장 큰 순열을 생성한다 => 가장 큰 순열을 생성하면 NP는 더 이상 순열을 생성하지 않는다 = > 종료
 * 	ex)
 * 	1 2 3 => 1 3 2=> 2 1 3=> 2 3 1 => 3 1 2 => 3 2 1
 * 
 *  1. 가장 큰 순열을 만들어 놓고 시작하기 ( 오름 차순 정렬을 먼저 한다)
 * 
 * 
 * 	2. 다음 순열을 생성
 *  	2.1  교차점 찾기
 *  		뒤쪽 부터 탐색해서 가장 큰 수(꼭대기:i)를 찾기
 *  		꼭대기 바로 앞의 숫자(i-1)를 교차점을 사용
 *  		만약에 i=0이면 (뒤에서 부터 가장 큰 숫자를 찾았는데 가장 큰 수가 첫번째 있다면)
 *  		최종 목표인 가장 큰 순열을 생성했기 때문에 return false한다 => 더이상 순열 생성 못함
 *  		ex) 1 3 5 4 2		i=2이므로 교차점할 i-1의 데이터인 3
 *  	
 *  
 *  	2-2 교차할 데이터 위치 찾기
 *  		뒤쪼에서 탐색해서 i-1의 데이터보다 큰 값(j)를 찾기
 *  
 *  	2-3 i-1과 j의 데이터를 swap
 *  		ex) 1 4 5 3 2
 *  	
 *  	2-4	교환 후의 데이터는 교환점(i-1) 이후는 내림 차순으로 되어 있다
 *  		다음 큰 순열을 만들기 위해서는 교환점(i-1)이후를 오름 차순으로 변경해야 한다.
 *  		==> 꼭지(i)와 면 뒤 수를 swap 하는 방식으로 오름 차순으로 변경한다.
 * @author THKim
 * 
 * 
 * 
 * 	
 *
 */
public class NextPermutation {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N];
		
		for(int i=0;i<N;i++) {
			input[i] = sc.nextInt();
		}
		
		/* 1. 가장 작은 순열을 만들어 놓고 시작하기 
		 * 전처리
		 * 
		 * 
		 */
		Arrays.sort(input);
		
		do {
			System.out.println(Arrays.toString(input));
		}
		while(np(input));
	}
	
	
	public static boolean np(int[] numbers) {
		int N = numbers.length;
		// 1. 꼭대기 찾기
		int i = N-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		
		if(i==0) return false; // 다음 순열을 만들 수 없는 이미 가장 큰 순열의 상태!
		
		//2. 꼭대기의 바로 앞자리(i-1)의 값을 크게 만들 교환 값 뒤쪽에서 찾기
		int j = N-1;
		while(numbers[i-1]>=numbers[j]) --j;
		
		
		//3. i-1 위치값과 j 위치값 교환
		swap(numbers,i-1,j);
		
		// i위치 부터 맨뒤까지의 수열을 가장 작은 형태의 오름 차순으로 변경
		int k = N-1;
		while(i<k)	swap(numbers,i++,k--);
		
		return true;
	}
	
	public static void swap(int[]numbers,int i,int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
}
