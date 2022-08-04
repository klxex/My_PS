package datastructure;

import java.util.Arrays;

public class Stack {
	
	int stack_point;
	int[] buf;
	int index = -1;
	static int size = 50;
	public Stack() {
		int[] buf = new int[size];
	}
	
	public void push(int a) {
		if(index+1<size) {
			buf[++index] = a;
		}
		else {
			
			Arrays.copyOf(buf,size);
		}
		
	}
	
	public int pop() {
		
		return 0;
	}
	
	
	public static void main(String[] args) {
		
	}
}
