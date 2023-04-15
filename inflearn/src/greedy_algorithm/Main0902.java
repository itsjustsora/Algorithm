package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main0902 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Time> arr = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			arr.add(new Time(s, e));
		}
		System.out.println(solution(arr, N));
	}

	private static int solution(ArrayList<Time> arr, int n) {
		int cnt = 1;
		Collections.sort(arr);

		int end = arr.get(0).end;
		for (int i = 1; i < n; i++) {
			if (end <= arr.get(i).start) {
				cnt++;
				end = arr.get(i).end;
			}
		}
		return cnt;
	}
}

class Time implements Comparable<Time> {
	int start;
	int end;
	public Time(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Time o) {
		if (this.end == o.end) {
			return this.start - o.start;
		}
		return this.end - o.end;
	}
}
