package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main0608 {

	/*
	 * 순차 검색은 O(n), 이분 검색은 O(log n)
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(N, M, arr));

	}

	private static int solution(int n, int m, int[] arr) {
		int answer = 0;
		int lt = 0, rt = n - 1;

		Arrays.sort(arr);
		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (arr[mid] == m) {
				answer = mid + 1;
				break;
			}
			if (arr[mid] > m) rt = mid - 1;
			else lt = mid + 1;
		}
		return answer;
	}
}
