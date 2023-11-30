package src.part3.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 감시_피하기 {

	public static int n;
	public static String answer = "NO";
	public static Character[][] map;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new Character[n][n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}

		dfs(0);
		System.out.println(answer);
	}

	public static void dfs(int cnt) {
		if (cnt == 3) {
			if (bfs()) {
				answer = "YES";
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'X') {
					map[i][j] = 'O';
					dfs(cnt + 1);
					map[i][j] = 'X';
				}
			}
		}
	}

	private static boolean bfs() {
		Queue<int[]> queue = new LinkedList<>();
		Character[][] tmp = new Character[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tmp[i][j] = map[i][j];
				if (tmp[i][j] == 'T')
					queue.add(new int[] {i, j});
			}
		}

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now[0];
				int ny = now[1];

				while (true) {
					nx += dx[i];
					ny += dy[i];

					if (nx < 0 || ny < 0 || ny >= n || nx >= n) break;
					if (tmp[nx][ny] == 'O') break;
					if (tmp[nx][ny] == 'S') return false;
				}
			}
		}
		return true;
	}
}
