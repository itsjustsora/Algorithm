package depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10026 {
	static int n, aCnt = 0, bCnt= 0;
	static char[][] board;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		board = new char[n+1][n+1];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		aSolution();
		bSolution();

		System.out.println(aCnt + " " + bCnt);
	}

	private static void aSolution() {
		visited = new boolean[n+1][n+1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					DFS(i, j);
					aCnt++;
				}
			}
		}
	}

	private static void bSolution() {
		visited = new boolean[n+1][n+1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'G') board[i][j] = 'R';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					DFS(i, j);
					bCnt++;
				}
			}
		}
	}

	private static void DFS(int x, int y) {
		char ch = board[x][y];
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (!visited[nx][ny] && board[nx][ny] == ch) {
					DFS(nx, ny);
				}
			}
		}
	}

}
