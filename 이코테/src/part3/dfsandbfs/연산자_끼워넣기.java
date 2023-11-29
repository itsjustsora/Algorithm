package src.part3.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연산자_끼워넣기 {

	static int n;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] numbers;
	static int[] operator = new int[4];

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		numbers = new int[n];

		String[] str = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(str[i]);
		}

		String[] str2 = br.readLine().split(" ");
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(str2[i]);
		}

		dfs(1, numbers[0]);

		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int idx, int sum) {
		if (idx == n) {
			min = Math.min(sum, min);
			max = Math.max(sum, max);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {

				operator[i]--;
				switch (i) {
					case 0: dfs(idx + 1, sum + numbers[idx]);   break;
					case 1:	dfs(idx + 1, sum - numbers[idx]);   break;
					case 2:	dfs(idx + 1, sum * numbers[idx]);   break;
					case 3: dfs(idx + 1, sum / numbers[idx]);   break;
				}
				operator[i]++;
			}
		}
	}
}
