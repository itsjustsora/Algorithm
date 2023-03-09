package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] position = new int[N];
		for (int i = 0; i < N; i++) {
			position[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(position);
		int lt = 1, rt = position[N - 1];
		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			int ep = position[0];
			int cnt = 1;
			for (int i = 1; i < N; i++) {
				if (position[i] - ep >= mid) {
					cnt++;
					ep = position[i];
				}
			}

			if (cnt >= C) {
				lt = mid + 1;
			} else rt = mid - 1;
		}
		System.out.println(lt -1);
	}
}
