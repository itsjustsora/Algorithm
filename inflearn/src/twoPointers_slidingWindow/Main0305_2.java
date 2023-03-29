package twoPointers_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main0305_2 {
	public static int solution(int N) {
		int answer = 0, cnt = 1;
		N--;
		while (N > 0) {
			cnt++;
			N -= cnt;
			if (N % cnt == 0) answer++;
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		System.out.println(solution(N));

	}
}
