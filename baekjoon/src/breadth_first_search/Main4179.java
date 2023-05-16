package breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4179 {

	static int r, c;
	static String answer;
	static char[][] miro;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Point> queue1 = new LinkedList<>();
	static Queue<Point> queue2 = new LinkedList<>();
	static int[][] times1;
	static int[][] times2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken()); // 미로 행의 개수
		c = Integer.parseInt(st.nextToken()); // 미로 열의 개수

		miro = new char[r][c];
		times1 = new int[r][c];
		times2 = new int[r][c];

		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				miro[i][j] = str.charAt(j);
				times1[i][j] = -1;
				times2[i][j] = -1;
				if (miro[i][j] == 'F') {
					queue1.offer(new Point(i, j));
					times1[i][j] = 0;
				}
				if (miro[i][j] == 'J') {
					queue2.offer(new Point(i, j));
					times2[i][j] = 0;
				}
			}
		}

		BFS1();
		BFS2();

		System.out.println(answer);
	}

	private static void BFS1() {
		while (!queue1.isEmpty()) {
			Point cur = queue1.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
				if (times1[nx][ny] >= 0 || miro[nx][ny] == '#') continue;
				times1[nx][ny] = times1[cur.x][cur.y] + 1;
				queue1.offer(new Point(nx, ny));
			}
		}
	}

	private static void BFS2() {
		while (!queue2.isEmpty()) {
			Point cur = queue2.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
					answer = String.valueOf(times2[cur.x][cur.y] + 1);
					return;
				}
				if (times2[nx][ny] >= 0 || miro[nx][ny] == '#') continue;
				if (times1[nx][ny] != -1 && times2[cur.x][cur.y] + 1 >= times1[nx][ny]) continue;
				times2[nx][ny] = times2[cur.x][cur.y] + 1;
				queue2.offer(new Point(nx, ny));
			}
		}
		answer = "IMPOSSIBLE";
	}


}
