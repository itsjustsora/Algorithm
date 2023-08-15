package lv1;

public class 신규_아이디_추천 {
	public String solution(String new_id) {

		String answer = new_id.toLowerCase();

		answer = answer.replaceAll("[^a-z0-9-_.]", "")
			.replaceAll("\\.{2,}", ".")
			.replaceAll("^\\.|\\.$", "")
			.replaceAll("^$", "a");

		if (answer.length() >= 16) {
			answer = answer.substring(0, 15);
		}

		answer = answer.replaceAll("\\.$", "");

		while (answer.length() <= 2) {
			answer += answer.charAt(answer.length() - 1);
		}

		return answer;
	}
}
