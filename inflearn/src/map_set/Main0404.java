package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main0404 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String first = br.readLine();
		String second = br.readLine();


		System.out.print(solution(first, second));
	}

	private static int solution(String a, String b) {
		int answer = 0;
		Map<Character, Integer> am = new HashMap<>();
		Map<Character, Integer> bm = new HashMap<>();
		for (char x : b.toCharArray()) {
			bm.put(x, bm.getOrDefault(x, 0) + 1);
		}

		int len = b.length() - 1;
		for (int i = 0; i < len; i++) {
			am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
		}

		int lt = 0;
		for (int rt = len; rt < a.length(); rt++) {
			char nowRt = a.charAt(rt);
			am.put(nowRt, am.getOrDefault(nowRt, 0) + 1);
			if (am.equals(bm)) answer++;

			char nowLt = a.charAt(lt);
			am.put(nowLt, am.get(nowLt)-1);
			if (am.get(nowLt) == 0) am.remove(nowLt);
			lt++;
		}
		return answer;
	}
}
