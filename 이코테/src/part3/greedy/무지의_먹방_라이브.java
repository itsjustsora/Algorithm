package src.part3.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class 무지의_먹방_라이브 {
	public int solution(int[] food_times, long k) {
		long summary = 0;
		for (int i = 0; i < food_times.length; i++) {
			summary += food_times[i];
		}
		if (summary <= k) return -1;

		PriorityQueue<Food> pq = new PriorityQueue<>();
		for (int i = 0; i < food_times.length; i++) {
			pq.offer(new Food(food_times[i], i + 1));
		}

		summary = 0;
		long previous = 0;
		long length = food_times.length;

		while (summary + ((pq.peek().getTime() - previous) * length) <= k) {
			int now = pq.poll().getTime();
			summary += (now - previous) * length;
			length -= 1;
			previous = now;
		}

		ArrayList<Food> result = new ArrayList<>();
		while (!pq.isEmpty()) {
			result.add(pq.poll());
		}

		Collections.sort(result, (a, b) -> Integer.compare(a.getNumber(), b.getNumber()));
		return result.get((int) ((k - summary) % length)).getNumber();
	}
}

class Food implements Comparable<Food> {
	private int time;
	private int number;

	public Food(int time, int number) {
		this.time = time;
		this.number = number;
	}

	public int getTime() {
		return time;
	}

	public int getNumber() {
		return number;
	}

	public int compareTo(Food o) {
		return this.time - o.time;
	}
}
