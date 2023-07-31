package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일이_될_때까지 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;

		while (N != 1) {
			if (N % K == 0) {
				N /= K;
			} else {
				N -= 1;
			}
			cnt++;
		}

		System.out.println(cnt);
	}
}
