package src.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 미래_도시 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// n : 전체 회사의 개수, m : 경로의 개수
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] graph = new int[101][101];

		for (int i = 0; i < 101; i++) {
			Arrays.fill(graph[i], 101);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < n; j++) {
				if (i == j) graph[i][j] = 0;
			}
		}

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
				}
			}
		}

		st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int distance = graph[1][k] + graph[k][x];

		if (distance >= 101) {
			System.out.println(-1);
		} else {
			System.out.println(distance);
		}
	}
}
