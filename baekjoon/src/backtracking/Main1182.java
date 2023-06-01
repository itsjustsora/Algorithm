package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1182 {

	public static int[] arr;
	public static int cnt = 0;
	public static int n, s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0,0);
		System.out.println(s == 0 ? --cnt : cnt);
	}

	private static void dfs(int i, int sum) {
		if (i == n) {
			if (sum == s) {
				cnt++;
			}
			return;
		}
		dfs(i + 1, arr[i] + sum);
		dfs(i + 1, sum);
	}
}
