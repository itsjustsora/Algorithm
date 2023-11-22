package src.part3.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연구소 {

	public static int n, m;
	public static int answer = 0;
	public static int[][] map;
	public static int[][] tmp;
	public static int[] dx = {-1, 0, 1, 0}; // 서 북 동 남
	public static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		tmp = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		DFS(0);
		System.out.println(answer);
	}

	public static void DFS(int cnt) {
		if (cnt == 3) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					tmp[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (tmp[i][j] == 2) {
						virus(i, j);
					}
				}
			}
			answer = Math.max(answer, countZone());
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					cnt++;
					DFS(cnt);
					map[i][j] = 0;
					cnt--;
				}
			}
		}
	}

	public static void virus(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (tmp[nx][ny] == 0) {
					tmp[nx][ny] = 2;
					virus(nx, ny);
				}
			}
		}
	}

	private static int countZone() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tmp[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
