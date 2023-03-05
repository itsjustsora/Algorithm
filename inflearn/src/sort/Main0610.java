package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main0610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(N, C, arr));
	}

	private static int solution(int n, int c, int[] arr) {
		int answer = 0;

		Arrays.sort(arr);
		int lt = 1;
		int rt = arr[n-1];

		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (count(mid, arr) >= c) {
				answer = mid;
				lt = mid + 1;
			} else rt = mid - 1;
		}
		return answer;
	}

	private static int count(int dist, int[] arr) {
		int cnt = 1;
		int ep = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - ep >= dist) {
				cnt++;
				ep = arr[i];
			}
		}
		return cnt;
	}
}
