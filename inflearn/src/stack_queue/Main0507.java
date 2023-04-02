package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main0507 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String essential = br.readLine();
		String classes = br.readLine();

		System.out.println(solution(essential, classes));
	}

	private static String solution(String essential, String classes) {
		String answer = "YES";
		Queue<Character> queue = new LinkedList<>();

		for (char ch : essential.toCharArray()) {
			queue.offer(ch);
		}

		for (char ch : classes.toCharArray()) {
			if (queue.contains(ch)) {
				if (ch != queue.poll()) {
					return "NO";
				}
			}
		}

		if (!queue.isEmpty()) return "NO";
		return answer;
	}
}
