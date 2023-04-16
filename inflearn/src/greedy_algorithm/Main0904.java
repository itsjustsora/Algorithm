package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main0904 {

	static int N, max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		ArrayList<Lecture> arr = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			arr.add(new Lecture(m, d));
			if (d > max) max = d;
		}

		System.out.println(solution(arr));
	}

	private static int solution(ArrayList<Lecture> arr) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Collections.sort(arr);

		int j = 0;
		for (int i = max; i >= 1; i--) {
			for (; j < N; j++) {
				if (arr.get(j).days < i) break;
				pq.offer(arr.get(j).money);
			}
			if (!pq.isEmpty()) {
				answer += pq.poll();
			}
		}

		return answer;
	}
}

class Lecture implements Comparable<Lecture> {
	int money;
	int days;

	public Lecture(int money, int days) {
		this.money = money;
		this.days = days;
	}

	@Override
	public int compareTo(Lecture o) {
		return o.money - this.money;
	}
}