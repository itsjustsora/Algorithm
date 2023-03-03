package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main0604_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] cache = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cache[i] = Integer.parseInt(st.nextToken());
		}

		for (int i : solution(S, N, cache)) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);

	}

	private static int[] solution(int size, int n, int[] cache) {
		int[] result = new int[size];
		for (int x : cache) {
			int pos = -1;
			for (int i = 0; i < size; i++) {
				if (x == result[i]) pos = i;
			}
			if (pos == -1) {
				for (int i = size-1; i >= 1; i--) {
					result[i] = result[i-1];
				}
			} else {
				for (int i = pos; i >= 1; i--) {
					result[i] = result[i-1];
				}
			}
			result[0] = x;
		}
		return result;
	}
}
