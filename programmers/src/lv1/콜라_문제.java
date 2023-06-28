package lv1;

public class 콜라_문제 {
	public int solution(int a, int b, int n) {
		int answer = 0;
		int quotient = 0;

		while (n >= a) {
			quotient = n / a;

			n = (n % a) + quotient * b;
			answer += (quotient * b);
		}
		return answer;
	}
}
