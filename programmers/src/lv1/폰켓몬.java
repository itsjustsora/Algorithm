package lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solution(new int[] {3, 1, 2, 3}));
		System.out.println(solution(new int[] {3, 3, 3, 2, 2, 4}));
	}

	public static int solution(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int i : nums) {
			set.add(i);
		}

		int count = nums.length / 2;
		return set.size() > count ? count : set.size();
	}
}
