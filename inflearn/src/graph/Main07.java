package graph;

import java.io.IOException;

public class Main07 {

	/**
	 * 부분집합 구하기(DFS)
	 * 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력한다.
	 * 단, 공집합은 출력하지 않는다.
	 */

	static int N;
	static int[] ch;

	public static void DFS(int L) {
		if (L == N + 1) {
			String temp = "";
			for (int i = 1; i <= N; i++) {
				if (ch[i] == 1) temp += (i + " ");
			}
			if (temp.length() > 0)
				System.out.println(temp);
		} else {
			ch[L] = 1;
			DFS(L + 1);
			ch[L] = 0;
			DFS(L + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		N = 3;

		ch = new int[N + 1];
		DFS(1);
	}
}
