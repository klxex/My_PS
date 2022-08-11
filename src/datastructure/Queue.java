package datastructure;

import java.util.Arrays;

public class Queue {
	int data[];
	int start;
	int end;
	int size = 50;
	public Queue() {
		start = 0;
		end = 0;
		data = new int[size];
	}
	
	public void add(int a) {
		if(end == size) {
			size *= 2;
			data = Arrays.copyOf(data, size);
		}
		
		data[end++] = a;
	}
	
	public int remove() {
		if(start==end) {
			return -1;
		}
		
		return data[start++];
	}
	
	public static void main(String[] args) {
		
		Queue q = new Queue();
		
		for(int i=0;i<65;i++) {
			q.add(i);
		}
		
		for(int i=0;i<65;i++) {
			System.out.println(q.remove());
		}
	}
	
	
}
