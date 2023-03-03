package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main0604 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			if (list.contains(now)) {
				list.remove((Integer)now);
			}
			list.add(0, now);
		}

		for (int i = 0; i < S; i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);

	}
}
