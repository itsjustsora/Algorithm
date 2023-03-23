package lv2;

import java.util.ArrayList;
import java.util.List;

public class 프린터 {
	public int solution(int[] priorities, int location) {
		List<Group> queue = new ArrayList<>();
		for (int i = 0; i < priorities.length; i++) {
			int priority = priorities[i];
			queue.add(new Group(priority, i));
		}

		int time = 0;
		while(!queue.isEmpty()) {
			Group group = queue.remove(0);
			if (queue.stream().anyMatch(o -> group.priority < o.priority)) {
				queue.add(group);
			} else {
				time++;
				if (group.idx == location) {
					return time;
				}
			}
		}
		return time;
	}

	class Group {
		int priority;
		int idx;

		public Group(int priority, int idx) {
			this.priority = priority;
			this.idx = idx;
		}
	}
}
