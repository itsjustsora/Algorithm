package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 떡볶이_떡_만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] heights = new int[n];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, heights[i]);
		}

		int start = 0;
		int end = max;
		while (start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;

			for (int i = 0; i < n; i++) {
				if (heights[i] > mid) sum += heights[i] - mid;
			}

			if (sum < m) {
				end = mid - 1;
			} else {
				answer = mid;
				start = mid + 1;
			}
		}

		System.out.println(answer);

	}
}
