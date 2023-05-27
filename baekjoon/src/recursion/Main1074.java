package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1074 {

	/**
	 * r, c가 사분면 중 어디에 속해있는지 찾기
	 */

	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int size = (int) Math.pow(2, n);

		find(size, r, c);
		System.out.println(cnt);
	}

	private static void find(int size, int r, int c) {
		if (size == 1) return;
		if (r < size/2 && c < size/2) {
			find(size/2, r, c);
		} else if (r < size/2 && c >= size/2) {
			cnt += size * size / 4;
			find(size/2, r, c - size/2);
		} else if(r >= size/2 && c < size/2) {
			cnt += (size * size / 4) * 2;
			find(size/2, r - size/2, c);
		} else {
			cnt += (size * size / 4) * 3;
			find(size/2, r - size/2, c - size/2);
		}
	}
}
