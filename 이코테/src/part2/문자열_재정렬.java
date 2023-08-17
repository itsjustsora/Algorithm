package src.part2;

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
		String line = br.readLine();

		List<String> alphabets = new ArrayList<>();
		int sum = 0;

		for (int i = 0; i < line.length(); i++) {
			if ('A' <= line.charAt(i) && line.charAt(i) <= 'Z') { // Character.isLetter()
				alphabets.add(String.valueOf(line.charAt(i)));
			} else {
				sum += line.charAt(i) - '0';
			}
		}


		Collections.sort(alphabets);

		for (String str : alphabets) {
			sb.append(str);
		}

		if (sum != 0) sb.append(sum);
		System.out.println(sb);
	}
}
