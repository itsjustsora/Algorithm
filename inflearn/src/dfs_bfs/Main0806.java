package dfs_bfs;

public class Main0806 {
	static int[] pm, ch, arr;
	static int n, m;
	public void DFS(int L) {
		if (L == m) {
			for (int x : pm)
				System.out.println(x + " ");
		} else {
			for (int i = 0; i < n; i++) {
				if (ch[i] == 0) {
					ch[i] = 1;
					pm[L] = arr[i];
					DFS(L+1);
					ch[i]=0;
				}
			}
		}
	}
}
