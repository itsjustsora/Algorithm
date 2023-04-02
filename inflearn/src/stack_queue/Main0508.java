package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main0508 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] patients = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			patients[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(N, M, patients));
	}

	private static int solution(int n, int m, int[] patients) {
		int answer = 0;
		Queue<Person> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			queue.offer(new Person(i, patients[i]));
		}

		while (!queue.isEmpty()) {
			Person now = queue.poll();
			for (Person x : queue) {
				if (x.priority > now.priority) {
					queue.add(now);
					now = null;
					break;
				}
			}
			if (now != null) {
				answer++;
				if (now.id == m) return answer;
			}
		}
		return answer;
	}
}

class Person {
	int id;
	int priority;

	public Person(int id, int priority) {
		this.id = id;
		this.priority = priority;
	}
}
