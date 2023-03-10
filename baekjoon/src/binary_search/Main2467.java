package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2467 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] solution = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(binary(N, solution));
	}

	private static String binary(int n, int[] solution) {
		int lt = 0, rt = 0;
		long min = Long.MAX_VALUE;
		for (int i = 0; i < n-1; i++) {
			int left = i+1;
			int right = n-1;
			while (left <= right) {
				int mid = (left + right) / 2;
				long sum = Math.abs(solution[i] + solution[mid]);

				if (min > sum) {
					min = sum;
					lt = i;
					rt = mid;
				}
				if (solution[mid] >= -solution[i]) {
					right = mid - 1;
				} else left = mid + 1;
			}
		}

		return solution[lt] + " " + solution[rt];
	}
}
