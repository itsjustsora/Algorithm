package lv2;

import java.util.Arrays;

public class 가장_큰_수 {
	public String solution(int[] numbers) {
		String answer = "";
		String[] str = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			str[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

		for (String now : str) {
			answer += now;
		}

		if (str[0].equals("0")) {
			return "0";
		}

		return answer;
	}

	/* 다른 분의 깔끔한 코드! 스트림을 잘 활용했다.
	* import java.util.*;
		import java.util.stream.Collectors;

	class Solution {
    	public String solution(int[] numbers) {
			List<String> result = Arrays.stream(numbers).mapToObj(n -> String.valueOf(n)).collect(Collectors.toList());
			Collections.sort(result, (s1, s2) -> (s2+s1).compareTo(s1+s2));

			if(resu수lt.get(0).equals("0")) {
				return "0";
			}

			return result.stream().collect(Collectors.joining());
    	}
	}
	*
	*
	* */
}
