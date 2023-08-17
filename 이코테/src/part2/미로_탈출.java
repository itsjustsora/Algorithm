package src.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로_탈출 {

	public static int n, m;
	public static int[][] miro;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		miro = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				miro[i][j] = str.charAt(j) - '0';
			}
		}

		System.out.println(BFS(0, 0));
	}

	private static int BFS(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

				if (miro[nx][ny] == 0) continue;

				if (miro[nx][ny] == 1) {
					miro[nx][ny] = miro[x][y] + 1;
					queue.add(new Point(nx, ny));
				}
			}
		}
		return miro[n - 1][m - 1];
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

