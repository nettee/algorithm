package digraph;

import queue.LinkedQueue;
import queue.Queue;
import stack.LinkedStack;
import stack.Stack;

public class DFSOrder {
	private boolean[] marked;
	
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;
	
	public DFSOrder(Digraph G) {
		pre = new LinkedQueue<Integer>();
		post = new LinkedQueue<Integer>();
		reversePost = new LinkedStack<Integer>();
		marked = new boolean[G.V()];
		
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);
			}
		}
	}
	
	private void dfs(Digraph G, int v) {
		pre.enqueue(v);
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
		post.enqueue(v);
		reversePost.push(v);
	}
	
	public Iterable<Integer> pre() {
		return pre;
	}
	
	public Iterable<Integer> post() {
		return post;
	}
	
	public Iterable<Integer> reversePost() {
		return reversePost;
	}
}
