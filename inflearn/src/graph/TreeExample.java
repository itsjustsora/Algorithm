package graph;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	int data;
	Node lt, rt;

	public Node(int data) {
		this.data = data;
		this.lt = null;
		this.rt = null;
	}
}
public class TreeExample {
	Node root;

	public void DFS(Node root) {
		if (root == null) return;
		else {
			System.out.println(root.data + " "); // 전위순회
			DFS(root.lt);
			// System.out.println(root.data + " "); // 중위순회
			DFS(root.rt);
			// System.out.println(root.data + " "); // 후위순회
		}

	}

	public void BFS(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		int L = 0;

		while (!queue.isEmpty()) {
			int len = queue.size();
			System.out.print(len + " : ");
			for (int i = 0; i < len; i++) {
				Node current = queue.poll();
				System.out.print(current.data + " ");
				if (current.lt != null) queue.offer(current.lt);
				if (current.rt != null) queue.offer(current.rt);
			}
			L++;
			System.out.println();
		}
	}
	public static void main(String[] args) {
		TreeExample tree = new TreeExample();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);
		System.out.println("===== DFS =====");
		tree.DFS(tree.root);
		System.out.println("===== BFS =====");
		tree.BFS(tree.root);

	}
}
