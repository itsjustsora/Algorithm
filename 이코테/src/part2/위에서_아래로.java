package src.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 위에서_아래로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Integer[] arr = new Integer[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// for (int i = 1; i < N-1; i++) {
		// 	for (int j = i; j < N; j++) {
		// 		if (arr[j] > arr[j - 1]) {
		// 			int temp = arr[j];
		// 			arr[j] = arr[j-1];
		// 			arr[j-1] = temp;
		// 		}
		// 	}
		// }

		Arrays.sort(arr, Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
