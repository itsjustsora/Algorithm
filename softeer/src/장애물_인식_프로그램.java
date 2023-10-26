package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 장애물_인식_프로그램 {

	public static int n;
	public static int[][] block;
	public static boolean[][] visited;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, -1, 0, 1};
	public static ArrayList<Integer> list;

	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		block = new int[n][n];
		visited = new boolean[n][n];
		list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				block[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (block[i][j] == 1 && !visited[i][j]) {
					cnt++;
					bfs(i, j);
				}
			}
		}

		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		for (int answer : list) {
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();

		visited[x][y] = true;
		queue.add(new int[] {x, y});

		int size = 1;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int w = now[0];
			int h = now[1];

			for (int i = 0; i < 4; i++) {
				int nx = w + dx[i];
				int ny = h + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

				if (block[nx][ny] == 0 || visited[nx][ny]) continue;

				if (block[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.add(new int[]{nx, ny});
					size++;
				}
			}
		}
		list.add(size);
	}
}
