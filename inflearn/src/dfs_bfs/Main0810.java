package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main0810 {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] board;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		board = new int[8][8];
		for (int i = 1; i<= 7; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 7; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		board[1][1] = 1; // 출발점 체크
		DFS(1, 1);
		System.out.println(answer);
	}

	private static void DFS(int x, int y) {
		if (x == 7 && y == 7) {
			answer++;
		} else {
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 1 && nx <=7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
					board[nx][ny] = 1;
					DFS(nx, ny);
					board[nx][ny] = 0;
				}
			}
		}
	}
}
