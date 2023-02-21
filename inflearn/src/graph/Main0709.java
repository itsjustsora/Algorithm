package graph;

import java.io.IOException;

public class Main0709 {
	/**
	 * DFS
	 * 이진트리에서 루트 노드 1에서 말단 노드까지의 길이 중 가장 짧은 길이를 구하라.
	 * 루트 노드에서 말단 노드까지 가는데 이동하는 횟수 = 간선의 개수
	 */
	Node root;
	public static void main(String[] args) throws IOException {
		Main0709 tree = new Main0709();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		System.out.println(tree.DFS(0, tree.root));

	}

	private int DFS(int L, Node root) {
		if (root.lt == null && root.rt == null) {
			return L;
		} else {
			return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt));
		}
	}
}
