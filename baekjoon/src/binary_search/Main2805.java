package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] trees = new int[N];
		int max = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if (max < trees[i]) max = trees[i];
		}

		System.out.println(solution(M, max, trees));

	}

	private static int solution(int m, int rt, int[] trees) {
		int lt = 0;

		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (count(mid, trees) >= m) {
				lt = mid + 1;
			} else rt = mid - 1;
		}
		return lt - 1;
	}

	private static long count(int mid, int[] trees) {
		long sum = 0;
		for (int i = 0; i < trees.length; i++) {
			if (trees[i] - mid > 0) sum += (trees[i] - mid);
		}
		return sum;
	}
}
