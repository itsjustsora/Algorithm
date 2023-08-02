package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음료수_얼려_먹기 {

	public static int n, m;
	public static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (DFS(i, j)) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	public static boolean DFS(int x, int y) {
		if (x <= -1 || x >= n || y <= -1 || y >= m) {
			return false;
		}
		if (arr[x][y] == 0) {
			arr[x][y] = 1;

			DFS(x-1, y);
			DFS(x, y-1);
			DFS(x+1, y);
			DFS(x, y+1);
			return true;
		}
		return false;
	}
}
