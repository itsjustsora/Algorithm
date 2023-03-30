package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main0405 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] card = new int[N];
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(N, K, card));

	}

	private static int solution(int n, int k, int[] card) {
		int answer = 0;
		TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int l = j + 1; l < n; l++) {
					Tset.add(card[i] + card[j] + card[l]);
				}
			}
		}

		int cnt = 0;
		for (int i : Tset) {
			cnt++;
			if (cnt == k) answer = i;
		}

		return answer;
	}
}
