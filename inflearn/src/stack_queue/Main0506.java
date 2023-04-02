package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main0506 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		System.out.println(solution(N, K));
	}

	private static int solution(int n, int k) {
		int answer = 0;
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}

		while (!queue.isEmpty()) {
			for (int i = 1; i < k; i++) {
				queue.offer(queue.poll());
			}
			queue.poll();
			if (queue.size() == 1) answer = queue.poll();
		}
		return answer;
 	}
}