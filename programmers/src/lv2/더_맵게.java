package lv2;

import java.util.PriorityQueue;

public class 더_맵게 {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue();

		for (int score : scoville) {
			pq.offer(score);
		}

		int answer = 0;
		int min = pq.peek();
		while (K > min && pq.size() > 1) {
			answer++;
			int a = pq.poll();
			int b = pq.poll();
			int tmp = a + (b * 2);
			pq.add(tmp);
			min = pq.peek();
		}

		if (K > min) {
			return -1;
		}

		return answer;

	}
}
