package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main11728 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		List<Integer> list = new ArrayList<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list);

		for (int i : list) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
