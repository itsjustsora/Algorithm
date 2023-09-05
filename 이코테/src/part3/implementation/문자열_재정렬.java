package src.part3.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 문자열_재정렬 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();

		List<Character> list = new ArrayList<>();
		int sum = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch >= 'A' && ch <= 'Z') {
				list.add(ch);
			} else {
				sum += ch - '0';
			}
		}

		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		if (sum != 0)
			sb.append(sum);
		System.out.println(sb);
	}
}
