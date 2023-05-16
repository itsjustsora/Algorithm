package breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178 {

	static int[][] miro, dis;
	static int n, m;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		miro = new int[n+1][m+1];
		dis = new int[n+1][m+1];

		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			for (int j = 1; j <= m; j++) {
				miro[i][j] = Character.getNumericValue(str.charAt(j - 1));
			}
		}

		dis[1][1] = 1;
		BFS(1, 1);

		if (dis[n][m] == 0)
			System.out.println(-1);
		else
			System.out.println(dis[n][m]);
	}

	public static void BFS(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));
		miro[x][y] = 0;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx > 0 && nx <= n && ny > 0 && ny <= m && miro[nx][ny] == 1) {
					miro[nx][ny] = 0;
					queue.offer(new Point(nx, ny));
					dis[nx][ny] = dis[cur.x][cur.y] + 1;
				}
			}
		}
	}
}

