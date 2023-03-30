package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main0402 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String first = br.readLine();
		String second = br.readLine();

		System.out.println(solution(first, second));
	}

	private static String solution(String first, String second) {
		String answer = "YES";

		Map<Character, Integer> map = new HashMap<>();
		for (char key : first.toCharArray()) {
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		for (char key : second.toCharArray()) {
			map.put(key, map.get(key) - 1);
		}

		for (char key : map.keySet()) {
			if (map.get(key) > 0) {
				answer = "NO";
			}
		}

		return answer;
	}
}
