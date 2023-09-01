package src.part3.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 모험가_길드 {

	// 모험가 N명
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 모험가 N명
		int n = Integer.parseInt(br.readLine());
		int[] scores = new int[n];

		// 공포도가 X인 모험가는 반드시 X명 이상으로 구성한 모험가 그룹에 참여해야 함
		// 모든 모험가가 그룹에 들어가지 않아도 됨
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(scores);

		int answer = 0;
		int cnt = 0;
		for (int score : scores) {
			cnt++;
			if (score <= cnt) {
				answer++;
				cnt = 0;
			}
		}

		// 최대 몇 개의 모험가 그룹을 만들 수 있는지 (최댓값)
		System.out.println(answer);
	}
}
