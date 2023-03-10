package lv2;

import java.io.BufferedReader;

public class 덧칠하기 {
	public int solution(int n, int m, int[] section) {
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
