package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19637 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] names = new String[N];
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			names[i] = st.nextToken();
			nums[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			int input = Integer.parseInt(br.readLine());
			sb.append(solution(N, input, names, nums)).append("\n");
		}
		System.out.println(sb);
	}

	private static String solution(int n, int input, String[] names, int[] nums) {
		int lt = 0, rt = n - 1;

		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (nums[mid] < input) lt = mid + 1;
			else rt = mid - 1;
		}

		return names[lt];
	}
}
