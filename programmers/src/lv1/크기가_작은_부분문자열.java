package lv1;

public class 크기가_작은_부분문자열 {
	// 다음에는 substring 쓰기
	public int solution(String t, String p) {
		int answer = 0;
		int len = p.length();

		char[] arr = t.toCharArray();

		for (int i = 0; i <= arr.length - len; i++) {
			String num = "";
			for (int j = 0; j < len; j++) {
				num += arr[i+j];
			}
			long number = Long.parseLong(num);
			if (number <= Long.parseLong(p)) {
				answer++;
			}
		}
		return answer;
	}
}
