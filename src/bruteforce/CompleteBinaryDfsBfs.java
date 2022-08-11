package bruteforce;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CompleteBinaryDfsBfs {
	
	private char[] nodes;
	private int lastIndex;
	private final int SIZE;
	
	public CompleteBinaryDfsBfs(int size) {
		SIZE = size;
		nodes = new char[size+1];
	}
	
	public boolean add(char e) {
		if(lastIndex == SIZE) {
			return false;
		}
		
		nodes[++lastIndex] = e;
		return true;
	}
	
	public void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(nodes[current] + " ");
			
			if(current*2<=lastIndex)queue.offer(current*2);
			if(current*2+1<=lastIndex)queue.offer(current*2+1);
		}
		
		System.out.println();
	}
	
	public void bfs2() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(--size>=0) {
				int current = queue.poll();
				System.out.println(nodes[current]+" ");
				
				if(current*2<=lastIndex) queue.offer(current*2);
				if(current*2<=lastIndex) queue.offer(current*2+1);
				System.out.println();
			}
			
			System.out.println();
		}
	}
	
	
	public void dfs() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		
		while(!stack.isEmpty()) {
			int current = stack.pop();
			System.out.println(nodes[current] + " ");
			
			if(current*2<=lastIndex)stack.push(current*2);
			if(current*2+1<=lastIndex)stack.push(current*2+1);
		}
		
		System.out.println();
	}
	
	public void dfsByPreOrder(int current) {
		System.out.println(nodes[current]+" ");
		if(current*2<=lastIndex)dfsByPreOrder(current*2);
		if(current*2+1<=lastIndex)dfsByPreOrder(current*2+1);
	}
	
	public void dfsByPostOrder(int current) {
		if(current*2<=lastIndex)dfsByPostOrder(current*2);
		if(current*2+1<=lastIndex)dfsByPostOrder(current*2+1);
		System.out.print(nodes[current]+" ");
	}
	
	public void dfsByInOrder(int current) {
		if(current*2<=lastIndex)dfsByInOrder(current*2);
		System.out.print(nodes[current]+" ");
		if(current*2+1<=lastIndex)dfsByInOrder(current*2+1);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CompleteBinaryDfsBfs tree = new CompleteBinaryDfsBfs(9);
		for(int i=0;i<9;i++) {
			tree.add((char)('A'+i));
		}
		
//		tree.bfs();
//		tree.dfs();
		
		
		tree.dfsByPreOrder(1);
		System.out.println();
		tree.dfsByInOrder(1);
		System.out.println();
		tree.dfsByPostOrder(1);
		System.out.println();
	}

}
