package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6236 {

	static int N, M;
	static int[] money;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		money = new int[N];
		int max = 0, sum = 0;
		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(br.readLine());
			if (max < money[i]) max = money[i];
			sum += money[i];
		}

		System.out.println(solution(max, sum));
	}

	private static int solution(int lt, int rt) {
		int start = lt, end = rt;

		while (start <= end) {
			int mid = (start + end) / 2;
			int cnt = 1;
			int remain = mid;
			for (int i = 0; i < N; i++) {
				if (money[i] > remain) {
					remain = mid;
					cnt++;
				}
				remain -= money[i];
			}
			if (cnt > M) {
				start = mid + 1;
			}else end = mid - 1;
		}
		return start;
	}
}
