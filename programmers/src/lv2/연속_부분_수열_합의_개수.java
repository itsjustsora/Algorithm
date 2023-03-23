package lv2;

import java.util.HashSet;
import java.util.Set;

public class 연속_부분_수열_합의_개수 {
	public int solution(int[] elements) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j < elements.length; j++) {
				int sum = 0;
				for (int k = i; k < i + j; k++) {
					sum += elements[k % elements.length];
				}
				set.add(sum);
			}
		}
		return set.size();
	}
}
