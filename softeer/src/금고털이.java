package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 금고털이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;

		int bag = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		ArrayList<int[]> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}

		Collections.sort(list, (o1, o2) -> o2[1] - o1[1]);

		for (int[] jewel : list) {
			if (bag <= jewel[0]) {
				answer += bag * jewel[1];
				break;
			} else {
				answer += jewel[0] * jewel[1];
				bag -= jewel[0];
			}
		}

		System.out.println(answer);
	}
}
