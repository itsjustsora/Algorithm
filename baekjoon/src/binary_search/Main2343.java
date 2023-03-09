package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] times = new int[N];
		int sum = 0;
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(st.nextToken());
			sum += times[i];
			max = Math.max(max, times[i]);
		}

		// max 값으로 해야 모두를 다 담을 수 있기 때문에 - 이거 때문에 통과가 안 됐었음
		int lt = max, rt = sum;
		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			int remain = mid;
			int cnt = 1;
			for (int i = N - 1; i >= 0; i--) {
				if (times[i] > remain) {
					cnt++;
					remain = mid;
				}
				remain -= times[i];
			}

			if (cnt <= M) {
				rt = mid - 1;
			} else lt = mid + 1;
		}
		System.out.println(lt);
	}
}
