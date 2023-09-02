package src.part3.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 볼링공_고르기 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 볼링공 N개
		// 볼링공의 무개 1 ~ M
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] balls = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			balls[i] = Integer.parseInt(st.nextToken());
		}

		// 두 사람이 공을 고르는 경우의 수
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			int now = balls[i];
			for (int j = i+1; j <= n; j++) {
				if (now == balls[j]) {
					continue;
				}
				answer++;
			}
		}
		System.out.println(answer);


		// 이코테 정답 -> m을 활용
		/*
		int[] arr = new int[11];

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			arr[x] += 1;
		}

		int answer = 0;

		for (int i = 1; i <= m; i++) {
			n -= arr[i];
			answer += arr[i] * n;
		}

		*/
	}
}
