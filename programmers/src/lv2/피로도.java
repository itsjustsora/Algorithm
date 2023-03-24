package lv2;

public class 피로도 {
	int answer = 0;
	boolean[] visit;
	int[][] dungeons;

	public int solution(int k, int[][] dungeons) {
		visit = new boolean[dungeons.length];
		this.dungeons = dungeons;

		dfs(0, k);

		return answer;
	}

	private void dfs(int depth, int k) {

		for (int i = 0; i < dungeons.length; i++) {
			if (!visit[i] && dungeons[i][0] <= k) {
				visit[i] = true;
				dfs(depth + 1, k - dungeons[i][1]);
				visit[i] = false;
			}
		}
		answer = Math.max(answer, depth);
	}
}
