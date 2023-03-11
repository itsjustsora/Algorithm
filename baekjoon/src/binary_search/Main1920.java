package binary_search;

import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());
			sb.append(solution(A, now)).append("\n");
		}
		System.out.println(sb);
	}

	private static int solution(int[] a, int now) {
		int lt = 0, rt = a.length-1;
		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (now == a[mid]) {
				return 1;
			}else if (now < a[mid]) {
				rt = mid - 1;
			} else lt = mid + 1;
		}
		return 0;
	}
}
