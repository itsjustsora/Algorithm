package lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 실패율 {
	static class Stage implements Comparable<Stage> {
		int stageNumber;
		double failureRate;

		public Stage(int stageNumber, double failureRate) {
			this.stageNumber = stageNumber;
			this.failureRate = failureRate;
		}

		@Override
		public int compareTo(Stage other) {
			if (this.failureRate == other.failureRate) {
				return Integer.compare(this.stageNumber, other.stageNumber);
			}
			return Double.compare(other.failureRate, this.failureRate);
		}
	}

	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int[] playersReached = new int[N + 2];
		int[] playersFailed = new int[N + 2];

		for (int stage : stages) {
			playersReached[stage]++;
		}

		playersFailed[N + 1] = playersReached[N + 1]; // 마지막 스테이지의 실패자 수는 도달자 수와 동일
		for (int i = N; i >= 1; i--) {
			playersFailed[i] = playersReached[i] + playersFailed[i + 1];
		}

		List<Stage> stageList = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			double failureRate = (playersReached[i] == 0) ? 0 : (double) playersReached[i] / playersFailed[i];
			stageList.add(new Stage(i, failureRate));
		}

		Collections.sort(stageList);

		for (int i = 0; i < stageList.size(); i++) {
			answer[i] = stageList.get(i).stageNumber;
		}

		return answer;
	}
}
