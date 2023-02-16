package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		ArrayList<Physical> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			list.add(new Physical(weight, height));
		}

		int len = list.size();
		for (int i = 0; i < len; i++) {
			Physical o1 = list.get(i);
			int rank = 1;
			for (int j = 0; j < len; j++) {
				if (i == j) continue;

				Physical o2 = list.get(j);
				if (o1.weight < o2.weight && o1.height < o2.height ) {
					rank++;
				}
			}
			sb.append(rank).append(" ");
		}
		System.out.println(sb);


	}
}
class Physical {
	int weight;
	int height;

	public Physical(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}
}
