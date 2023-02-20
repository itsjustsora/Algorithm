package depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2606 {

	static int[][] graph;
	static boolean[] check;
	static  int computerCnt;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		computerCnt = Integer.parseInt(br.readLine());
		int computerPairCnt = Integer.parseInt(br.readLine());

		graph = new int[computerCnt+1][computerCnt+1];
		check = new boolean[computerCnt+1];

		for (int i = 0; i < computerPairCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a][b] = graph[b][a] = 1;
		}

		dfs(1);
		System.out.println(cnt-1);

	}

	private static void dfs(int start) {
		if (check[start]) return;

		check[start] = true;
		cnt++;

		for (int i = 0; i <= computerCnt; i++) {
			if(graph[start][i] == 1 && !check[i]) dfs(i);
		}
	}
}
