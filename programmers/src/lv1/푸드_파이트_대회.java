package lv1;

public class 푸드_파이트_대회 {
	public String solution(int[] food) {
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < food.length; i++) {
			int num = food[i] / 2;
			for (int j = 0; j < num; j++) {
				sb.append(i);
			}
		}

		return sb.toString() + "0"
			+ sb.reverse().toString();
	}
}
