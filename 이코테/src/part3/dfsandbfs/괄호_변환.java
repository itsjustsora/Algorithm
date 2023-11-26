package src.part3.dfsandbfs;

public class 괄호_변환 {
	// 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
	// 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
	// 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
	public String solution(String p) {
		String answer = "";

		if (p.equals("")) return answer;

		int idx = findIndex(p);

		String u = p.substring(0, idx + 1);
		String v = p.substring(idx + 1);

		if (check(u)) {
			answer = u + solution(v);
		} else {
			answer = "(";
			answer += solution(v);
			answer += ")";

			u = u.substring(1, u.length() - 1);

			String tmp = "";
			for (int i = 0; i < u.length(); i++) {
				if (u.charAt(i) == '(') tmp += ")";
				else tmp += "(";
			}
			answer += tmp;
		}
		return answer;
	}

	// 균형잡힌 괄호 문자열
	public int findIndex(String p) {
		int cnt = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == ')') cnt++;
			else cnt--;
			if (cnt == 0) return i;
		}
		return -1;
	}

	// 올바른 괄호 문자열
	public boolean check(String p) {
		int cnt = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') cnt++;
			else {
				if (cnt == 0) return false;
				cnt--;
			}
		}
		return true;
	}
}
