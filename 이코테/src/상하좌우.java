package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상하좌우 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		char[] position = {'L', 'R', 'U', 'D'};

		int x = 1, y = 1;
		int nx = 0, ny = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			String plan = st.nextToken();
			for (int i = 0; i < 4; i ++) {
				if (plan.equals(String.valueOf(position[i]))) {
					nx = x + dx[i];
					ny = y + dy[i];
				}

				if (nx < 1 || ny < 1 || nx > N || ny > N) {
					continue;
				}

				x = nx;
				y = ny;
			}
		}
		System.out.println(x + " " + y);
	}
}
