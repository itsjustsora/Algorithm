package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main1004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Brick> list = new ArrayList<>();
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new Brick(a, b, c));
		}

		Collections.sort(list);
		dp[0] = list.get(0).h;
		int answer = dp[0];
		for (int i = 1; i< list.size(); i++) {
			int max_h = 0;
			for (int j = i-1; j >= 0; j--) {
				if (list.get(j).w > list.get(i).w && dp[j] > max_h) {
					max_h = dp[j];
				}
			}
			dp[i] = max_h + list.get(i).h;
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);

	}
}

class Brick implements Comparable<Brick> {
	public int s, h, w;

	Brick(int s, int h, int w) {
		this.s = s;
		this.h = h;
		this.w = w;
	}

	@Override
	public int compareTo(Brick o) {
		return o.s - this.s;
	}
}
