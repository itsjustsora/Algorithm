package src.part3.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨_배달 {

	public static int n, m;
	public static int answer = Integer.MAX_VALUE;
	public static int[][] map;
	public static ArrayList<int[]> house = new ArrayList<>();
	public static ArrayList<int[]> chicken = new ArrayList<>();
	public static boolean[] check;

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) house.add(new int[] {i, j});
				else if (map[i][j] == 2) chicken.add(new int[] {i, j});
			}
		}

		check = new boolean[chicken.size()];
		backtracking(0, 0);
		System.out.println(answer);

	}

	private static void backtracking(int depth, int start) {
		if (depth == m) {
			int total = 0;
			for (int[] h : house) {
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < chicken.size(); i++) {
					if (check[i]) {
						int[] c = chicken.get(i);
						int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
						min = Math.min(min, dist);
					}
				}
				total += min;
			}
			answer = Math.min(answer, total);
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			check[i] = true;
			backtracking(depth + 1, i + 1);
			check[i] = false;
		}
	}
}
