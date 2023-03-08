package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] lines = new int[K];
		long max = 0;
		for (int i = 0; i < K; i++) {
			lines[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, lines[i]);
		}

		System.out.println(solution(N, max, lines));


	}

	private static long solution(int n, long max, int[] lines) {
		long lt = 1, rt = max;

		while (lt <= rt) {
			long mid = (lt + rt) / 2;
			int cnt = 0;
			for (int i : lines) {
				cnt += (i / mid);
			}
			if (cnt < n) rt = mid - 1;
			else lt = mid + 1;
		}
		return (lt+rt)/2;
	}
}
