package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main0903 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<TimeTable> arr = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			arr.add(new TimeTable(s, 's'));
			arr.add(new TimeTable(e, 'e'));
		}
		System.out.println(solution(arr, N));
	}

	private static int solution(ArrayList<TimeTable> arr, int n) {
		int answer = Integer.MIN_VALUE;
		Collections.sort(arr);

		int cnt = 0;
		for (TimeTable obj : arr) {
			if (obj.state == 's') cnt++;
			else cnt--;
			answer = Math.max(answer, cnt);
		}
		return answer;
	}
}

class TimeTable implements Comparable<TimeTable> {
	int time;
	char state;
	public TimeTable(int time, char state) {
		this.time = time;
		this.state = state;
	}

	@Override
	public int compareTo(TimeTable o) {
		if (this.time == o.time) {
			return this.state - o.state;
		}
		return this.time - o.time;
	}
}
