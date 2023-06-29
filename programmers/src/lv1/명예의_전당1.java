package lv1;

import java.util.PriorityQueue;

public class 명예의_전당1 {
	public int[] solution(int k, int[] score) {
		int[] answer = new int[score.length];
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < score.length; i++) {
			queue.add(score[i]);
			if (queue.size() > k) {
				queue.poll();
			}
			answer[i] = queue.peek();
		}
		return answer;
	}
}
