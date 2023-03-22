package lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
	public List<Integer> solution(int[] progresses, int[] speeds) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
			queue.add(days);
		}

		int x = queue.poll();
		int cnt = 1;
		List<Integer> list = new ArrayList<>();
		while (!queue.isEmpty()) {
			if (x >= queue.peek()) {
				cnt++;
				queue.poll();
			} else {
				list.add(cnt);
				cnt = 1;
				x = queue.poll();
			}
		}
		list.add(cnt);

		return list;
	}
}
