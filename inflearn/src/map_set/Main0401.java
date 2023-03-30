package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main0401 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer.parseInt(br.readLine());
		String list = br.readLine();

		System.out.println(solution(list));
	}

	private static char solution(String s) {
		char answer = ' ';
		Map<Character, Integer> map = new HashMap<>();
		for (char x : s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		int max = Integer.MIN_VALUE;
		for (char x : map.keySet()) {
			if (map.get(x) > max) {
				max = map.get(x);
				answer = x;
			}
		}

		return answer;
	}

}
