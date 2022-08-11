package datastructure;

import java.util.Arrays;

public class Stack {
	
	int stack_point;
	int[] buf;
	int index = -1;
	static int size = 50;
	public Stack() {
		buf = new int[size];
	}
	
	public void push(int a) {
		if(index+1<size) {
			buf[++index] = a;
		}
		else {
			
			size *= 2;
			buf = Arrays.copyOf(buf,size);
			buf[++index] = a;
			
		}
		
	}
	
	public int pop() {
		if(index == -1) {
			return -1;
		}
		else {
			return buf[index--];
		}
	}
	
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		
		for(int i=0;i<66;i++) {
			stack.push(i);
		}
		
		for(int i=0;i<68;i++) {
			System.out.println(stack.pop());
		}
	}
	
}
