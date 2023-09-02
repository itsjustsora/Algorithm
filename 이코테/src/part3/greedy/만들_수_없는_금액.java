package src.part3.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 만들_수_없는_금액 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N개의 동전
		int n = Integer.parseInt(br.readLine());
		Integer[] coins = new Integer[n];


		String[] split = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(split[i]);

		}

		Arrays.sort(coins, Collections.reverseOrder());


		// N개의 동전을 이용해 만들 수 없는 양의 정수 금액 중 최솟값
		int answer = 0;
		for (int i = 1; i < 10001; i++) {
			int total = i;
			for (int j = 0; j < n; j++) {
				if (coins[j] <= i && total >= 0) {
					total -= coins[j];
				}

				if (total == 0) {
					break;
				}
			}
			if (total > 0) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}
