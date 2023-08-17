package src.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시각 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;

		for (int i = 0; i < N+1; i++) {
			for (int j = 0; j <60; j++) {
				for (int k = 0; k < 60; k++) {
					if (check(i, j, k)) {
						count++;
					}
				}
			}
		}

		System.out.println(count);
	}

	// '3'이 포함되어 있는지 여부 확인
	public static boolean check(int h, int m, int s) {
		if (h / 10 == 3 || m / 10 == 3 || s / 10 == 3 || h % 10 == 3 ||
		m % 10 == 3 || s % 10 == 3) {
			return true;
		}
		return false;
	}
}
