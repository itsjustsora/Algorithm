package lv1;

public class 옹알이2 {
	public int solution(String[] babbling) {
		int answer = 0;
		String[] words = {"aya", "ye", "woo", "ma"};

		for (String bab : babbling) {
			for (String word : words) {
				if (bab.contains(word.repeat(2))) continue;
				bab = bab.replace(word, " ");
			}
			bab = bab.replace(" ", "");
			if (bab.equals("")) answer++;
		}
		return answer;
	}
}
