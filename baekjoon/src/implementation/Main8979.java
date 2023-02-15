package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main8979 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] info = new int[N+1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());

			info[idx][0] = Integer.parseInt(st.nextToken());
			info[idx][1] = Integer.parseInt(st.nextToken());
			info[idx][2] = Integer.parseInt(st.nextToken());
		}

		int gold = info[K][0];
		int silver = info[K][1];
		int bronze = info[K][2];

		int rank = 1;
		for (int i = 1; i < N+1; i++) {
			if (i == K) continue;

			if (gold < info[i][0]) {
				rank++;
			}
			else if (gold == info[i][0] && silver < info[i][1]) {
				rank++;
			}
			else if (gold == info[i][0] && silver == info[i][1] && bronze < info[i][2]) {
				rank++;
			}
		}
		System.out.println(rank);
	}
}
