package lv1;

import java.util.Arrays;
import java.util.Collections;

public class 숫자_짝꿍 {
	class Solution {
		public String solution(String X, String Y) {
			StringBuilder sb = new StringBuilder();
			int[] nums = new int[10];

			for (int i = 0; i < X.length(); i++) {
				int num = X.charAt(i) - '0';
				nums[num]++;
			}

			for (int i = 0; i < Y.length(); i++) {
				int num = Y.charAt(i) - '0';
				if (nums[num] > 0) {
					nums[num]--;
					sb.append(num);
				}
			}

			if (sb.length() == 0) return "-1";
			if (sb.toString().charAt(0) == '0') return "0";

			String[] split = sb.toString().split("");
			Arrays.sort(split, Collections.reverseOrder());

			return String.join("", split);
		}
	}

}
