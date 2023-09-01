package src.part3.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱하기_혹은_더하기 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 0부터 9로만 이루어진 문자열 S
		String s = br.readLine();

		// 왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인
		// 숫자 사이에 'x' 혹은 '+' 연산자를 넣어 결과적으로 만들어질 수 있는 가장 큰 수 구하기
		int answer = s.charAt(0) - '0';
		for (int i = 1; i < s.length(); i++) {
			int now = s.charAt(i) - '0';
			answer = Math.max(answer + now, answer * now);
		}
		System.out.println(answer);
	}
}
