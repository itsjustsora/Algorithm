package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GBC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] info = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}

		int[][] speed = new int[m][2];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			speed[i][0] = Integer.parseInt(st.nextToken());
			speed[i][1] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = idx; j < m; j++) {
				if (info[i][0] < speed[j][0]) {
					speed[j][0] -= info[i][0];
					if (speed[j][1] - info[i][1] > 0) answer = Math.max(answer, speed[j][1] - info[i][1]);
					break;
				} else if (info[i][0] > speed[j][0]) {
					info[i][0] -= speed[j][0];
					if (speed[j][1] - info[i][1] > 0) answer = Math.max(answer, speed[j][1] - info[i][1]);
					idx++;
				} else {
					if (speed[j][1] - info[i][1] > 0) answer = Math.max(answer, speed[j][1] - info[i][1]);
					idx++;
					break;
				}
			}
		}
		System.out.println(answer);
	}
}
