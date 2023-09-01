package src.part3.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_뒤집기 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 0과 1로만 이루어진 문자열 s
		String s = br.readLine();

		// 연속된 하나 이상의 숫자를 잡고 모두 뒤집어서 전부 같은 숫자로 바꾸기 (최소)
		int zeroCnt = 0;
		int oneCnt = 0;

		if (s.charAt(0) - '0' == 0) {
			zeroCnt++;
		} else {
			oneCnt++;
		}

		for (int i = 1; i < s.length() - 1; i++) {
			if (s.charAt(i) - '0' != s.charAt(i + 1) - '0') {
				if (s.charAt(i + 1) - '0' == 0) {
					zeroCnt++;
				} else {
					oneCnt++;
				}
			}
		}
		System.out.println(Math.min(zeroCnt, oneCnt));
	}
}
