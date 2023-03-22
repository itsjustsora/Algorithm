package lv2;

public class n2_배열_자르기 {
	//n^2 배열 자르기
	public int[] solution(int n, long left, long right) {
		int len = (int)right - (int)left;
		int[] result = new int[len+1];

		int idx = 0;
		for (long i = left; i <= right; i++) {
			int max = (int) Math.max(i/n, i%n);
			result[idx++] = max + 1;
		}

		return result;
	}
}
