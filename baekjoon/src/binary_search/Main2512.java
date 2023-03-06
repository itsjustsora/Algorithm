package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2512 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] budget = new int[N];
		for (int i = 0; i < N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());

		System.out.println(solution(N, M, budget));
	}

	private static int solution(int n, int m, int[] budget) {
		int answer = 0;
		int lt = 0;
		int rt = Arrays.stream(budget).max().getAsInt();

		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (total(mid, budget) <= m) {
				answer = mid;
				lt = mid + 1;
			} else rt = mid - 1;
		}
		return answer;
	}

	private static int total(int size, int[] budget) {
		int sum = 0;
		for (int i : budget) {
			if (i > size) {
				i = size;
			}
			sum += i;
		}
		return sum;
	}
}
