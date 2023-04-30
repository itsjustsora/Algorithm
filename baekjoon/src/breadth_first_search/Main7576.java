package breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7576 {
	static int[][] storage, days;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int m, n;
	static Queue<Position> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		storage = new int[n][m];
		days = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				storage[i][j] = Integer.parseInt(st.nextToken());
				if (storage[i][j] == 1) queue.offer(new Position(i, j));
			}
		}

		BFS();
		boolean flag = true;
		int answer = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (storage[i][j] == 0) {
					flag = false;
				}
			}
		}

		if (flag) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					answer = Math.max(answer, days[i][j]);
				}
			}
			System.out.println(answer);
		}
		else System.out.println(-1);
	}

	public static void BFS() {
		while (!queue.isEmpty()) {
			Position now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && storage[nx][ny] == 0) {
					storage[nx][ny] = 1;
					queue.offer(new Position(nx, ny));
					days[nx][ny] = days[now.x][now.y] + 1;
				}

			}
		}
	}
}

class Position {
	int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
