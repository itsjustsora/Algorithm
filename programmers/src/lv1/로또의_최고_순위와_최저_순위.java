package lv1;

public class 로또의_최고_순위와_최저_순위 {
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		int totalCnt = 7;
		int zeroCnt = 0;
		int winCnt = 0;

		for (int i = 0; i < lottos.length; i++) {
			if (lottos[i] == 0) {
				zeroCnt++;
				continue;
			}
			for (int j = 0; j < win_nums.length; j++) {
				if (lottos[i] == win_nums[j]) winCnt++;
			}
		}

		answer[0] = Math.min(totalCnt - (winCnt + zeroCnt), 6);
		answer[1] = Math.min(totalCnt - winCnt, 6);

		return answer;
	}
}
