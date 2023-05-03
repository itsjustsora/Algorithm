package it_prep.section6;

import java.util.ArrayList;
import java.util.Comparator;

public class Main0601 {
	int answer, target, m;
	int[] visited;
	boolean flag;
	ArrayList<Integer> list;
	public int solution(int n){
		answer = 0;
		flag = false;
		list = new ArrayList<>();
		target = n;
		int tmp = n;

		while (tmp > 0) {
			list.add(tmp % 10);
			tmp = tmp / 10;
		}
		list.sort(Comparator.comparingInt(a -> a));
		m = list.size();
		visited = new int[m];

		DFS(0, 0);

		if (!flag) return -1;

		return answer;
	}

	private void DFS(int L, int number) {
		if (flag) return;
		if (L == m) {
			if (number > target) {
				answer = number;
				flag = true;
			}
		} else {
			for (int i = 0; i < m; i++) {
				if (visited[i] == 0) {
					visited[i] = 1;
					DFS(L + 1, number * 10 + list.get(i));
					visited[i] = 0;
				}
			}
		}
	}

	public static void main(String[] args){
		Main0601 T = new Main0601();
		System.out.println(T.solution(123));
		System.out.println(T.solution(321));
		System.out.println(T.solution(20573));
		System.out.println(T.solution(27711));
		System.out.println(T.solution(54312));
	}
}
