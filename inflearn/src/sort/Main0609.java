package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main0609 {
	/*
		결정 알고리즘을 이용하여 최소 용량 크기를 출력하라.
		일정 범위 내에 내가 원하는 답이 있다고 확신한다면 결정 알고리즘 사용하기
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] songs = new int[N];
		for (int i = 0; i < N; i++) {
			songs[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(N, M, songs));



	}

	private static int solution(int n, int m, int[] songs) {
		int answer = 0;
		// 큰 데이터의 최댓값과 합을 찾을 때는 Arrays.stream() 이용하기
		int lt = Arrays.stream(songs).max().getAsInt();
		int rt = Arrays.stream(songs).sum();

		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (count(songs, mid) <= m) {
				answer = mid;
				rt = mid - 1;
			} else lt = mid + 1;
		}
		return answer;
	}

	private static int count(int[] songs, int capacity) {
		int cnt = 1, sum = 0;
		for (int i : songs) {
			if (sum + i > capacity) {
				cnt++;
				sum = i;
			}
			else sum += i;
		}
		return cnt;
	}
}
