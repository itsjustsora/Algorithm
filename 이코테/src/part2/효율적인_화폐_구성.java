package src.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 효율적인_화폐_구성 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[] d = new int[m + 1];
		Arrays.fill(d, 10001);

		d[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = arr[i]; j <= m; j++) {
				if (d[j - arr[i]] != 10001) {
					d[j] = Math.min(d[j], d[j - arr[i]] + 1);
				}
			}
		}

		if (d[m] == 10001) {
			System.out.println(-1);
		}
		else {
			System.out.println(d[m]);
		}
	}
}
