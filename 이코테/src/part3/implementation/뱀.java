package src.part3.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 뱀 {

	public static int n, k, l;
	public static int[][] board = new int[101][101];
	public static Map<Integer, Character> map;
	public static int[] dx = {0, 1, 0, -1}; // 동 남 서 북
	public static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			String[] split = br.readLine().split(" ");

			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);

			board[a][b] = 1;
		}

		l = Integer.parseInt(br.readLine());
		map = new HashMap<>();

		for (int i = 0; i < l; i++) {
			String[] split = br.readLine().split(" ");
			map.put(Integer.parseInt(split[0]), split[1].charAt(0));
		}

		System.out.println(solution());
	}

	public static int turn(int direction, char c) {
		if (c == 'L') direction = (direction == 0) ? 3 : direction - 1;
		else direction = (direction + 1) % 4;
		return direction;
	}

	private static int solution() {
		int x = 1, y = 1;
		board[x][y] = 2;

		int direction = 0;
		int time = 0;
		int index = 0;

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});

		while (true) {
			int nx = x + dx[direction];
			int ny = y + dy[direction];

			if (nx >= 1 && ny >= 1 && nx <= n && ny <= n && board[nx][ny] != 2) {
				if (board[nx][ny] == 0) {
					board[nx][ny] = 2;
					queue.offer(new int[] {nx, ny});

					int[] now = queue.poll();
					board[now[0]][now[1]] = 0;
				} else if (board[nx][ny] == 1) {
					board[nx][ny] = 2;
					queue.offer(new int[] {nx, ny});
				}
			} else {
				time++;
				break;
			}

			x = nx;
			y = ny;
			time++;

			if (index < l && map.containsKey(time)) {
				direction = turn(direction, map.get(time));
				index++;
			}
		}
		return time;
	}
}
