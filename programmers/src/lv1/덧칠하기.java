package lv1;

public class 덧칠하기 {
	public static void main(String[] args) {
		System.out.println(solution(8, 4, new int[] {2,3,6}));
		System.out.println(solution(5, 4, new int[] {1,3}));
		System.out.println(solution(4, 1, new int[] {1,2,3,4}));
	}

	private static int solution(int n, int m, int[] section) {
		// 다시 푼 코드
		/*
		boolean[] wall = new boolean[n+2];

		for (int i = 0; i < section.length; i++) {
			wall[section[i]] = true;
		}

		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (wall[i]) {
				for (int j = 1; j <= m; j++) {
					if (wall[j]) {
						wall[j] = false;
					}
				}
				answer++;
			}
		}

		return answer;
		 */

		// 예전 참고 코드
		int maxPoint = 0, cnt = 0;
		for (int point : section) {
			if (maxPoint <= point) {
				maxPoint = point + m;
				cnt++;
			}
		}
		return cnt;
	}
}
