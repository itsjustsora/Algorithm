package depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1012 {
	static int[][] field;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int m, n, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());

			m = Integer.parseInt(st.nextToken());	// 열
			n = Integer.parseInt(st.nextToken());	// 행
			int pos = Integer.parseInt(st.nextToken());

			field = new int[n][m];
			for (int j = 0; j < pos; j++) {
				st = new StringTokenizer(br.readLine());

				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());

				field[x][y] = 1;
			}

			cnt = 0;
			solution();
			System.out.println(cnt);
		}
	}

	public static void solution() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (field[i][j] == 1) {
					field[i][j] = 0;
					DFS(i, j);
					cnt++;
				}
			}
		}
	}

	private static void DFS(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < m && field[nx][ny] == 1) {
				field[nx][ny] = 0;
				DFS(nx, ny);
			}
		}
	}
}
