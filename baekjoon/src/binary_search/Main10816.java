package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10816 {

	/*
		upper bound와 lower bound에 대한 개념을 알고 있는 것이 중요!
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		int[] cards = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());
			sb.append(upperbound(cards, now) - lowerbound(cards, now)).append(" ");
		}
		System.out.println(sb);

	}

	private static int lowerbound(int[] cards, int now) {

		int lt = 0, rt = cards.length;

		while (lt < rt) {
			int mid = (lt + rt) / 2;
			if (now <= cards[mid]) {
				rt = mid;
			} else lt = mid + 1;
		}
		return lt;
	}

	private static int upperbound(int[] cards, int now) {

		int lt = 0, rt = cards.length;

		while (lt < rt) {
			int mid = (lt + rt) / 2;
			if (now < cards[mid]) {
				rt = mid;
			} else lt = mid + 1;
		}
		return lt;
	}
}
