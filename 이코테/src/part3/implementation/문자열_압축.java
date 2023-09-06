package src.part3.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_압축 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int answer = s.length();
		int cnt = 1;


		for (int i = 1; i <= s.length() / 2; i++) {
			StringBuilder sb = new StringBuilder();
			String base  = s.substring(0, i);

			for (int j = i; j <= s.length(); j += i) {
				int idx = Math.min(j + i, s.length());
				String compare = s.substring(j, idx);

				if (base.equals(compare)) {
					cnt++;
				} else {
					if (cnt >= 2) {
						sb.append(cnt);
					}
					sb.append(base);
					base = compare;
					cnt = 1;
				}
			}
			sb.append(base);
			answer = Math.min(answer, sb.length());
		}
		System.out.println(answer);
	}
}
