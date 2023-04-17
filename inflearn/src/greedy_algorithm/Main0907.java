package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main0907 {
	static int[] unf;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		unf = new int[n+1];
		ArrayList<Edge2> arr = new ArrayList<>();
		for (int i = 1; i <= n; i++) unf[i] = i;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			arr.add(new Edge2(a, b, c));
		}

		int answer = 0;
		Collections.sort(arr);
		for (Edge2 obj : arr) {
			int fv1 = Find(obj.v1);
			int fv2 = Find(obj.v2);
			if (fv1 != fv2) {
				answer += obj.cost;
				Union(obj.v1, obj.v2);
			}
		}

		System.out.println(answer);
	}

	public static int Find(int v) {
		if (v == unf[v]) return v;
		else return unf[v] = Find(unf[v]);
	}

	public static void Union(int a, int b) {
		int fa = Find(a);
		int fb = Find(b);
		if (fa != fb) unf[fa] = fb;
	}
}

class Edge2 implements Comparable<Edge2> {
	int v1;
	int v2;
	int cost;

	public Edge2(int v1, int v2, int cost) {
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge2 o) {
		return this.cost - o.cost;
	}
}