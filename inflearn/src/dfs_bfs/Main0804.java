package dfs_bfs;

public class Main0804 {
	// 중복순열 구하기
	static int[] pm;
	static int n, m;
	public void DFS(int L) {
		if (L == m) {
			for (int x : pm)
				System.out.println(x + " ");
		}
		else {
			for (int i = 1; i <= n; i++) {
				pm[L] = i;
				DFS(L + 1);
			}
		}
	}
}
