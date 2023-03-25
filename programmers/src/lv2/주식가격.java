package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 주식가격 {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Queue<Integer> queue = new LinkedList<>();

		for (int price : prices) {
			queue.add(price);
		}

		for (int i = 0; i < prices.length; i++) {
			int now = queue.poll();
			int idx = 0;
			for (int price : queue) {
				idx++;
				// 만약 now보다 작은 숫자가 없다면
				if (price < now) {
					answer[i] = idx;
					break;
				}
				answer[i] = queue.size();
			}
		}
		return answer;
	}
}
