package graph;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main0710 {
	/**
	 * DFS
	 * 이진트리에서 루트 노드 1에서 말단 노드까지의 길이 중 가장 짧은 길이를 구하라.
	 * 루트 노드에서 말단 노드까지 가는데 이동하는 횟수 = 간선의 개수
	 */
	Node root;
	public static void main(String[] args) throws IOException {
		Main0710 tree = new Main0710();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		System.out.println(tree.BFS(tree.root));

	}

	private int BFS(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		int L = 0;

		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				Node current = queue.poll();
				if (current.lt == null && current.rt == null) {
					return L;
				}
				if (current.lt != null) queue.offer(current.lt);
				if (current.rt != null) queue.offer(current.rt);
			}
			L++;
		}
		return 0;
	}
}
