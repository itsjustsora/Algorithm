package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main0505 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		System.out.println(solution(str));
	}

	private static int solution(String str) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push('(');
			} else {
				stack.pop();
				if (str.charAt(i-1) == '(') {
					answer += stack.size();
				} else {
					answer++;
				}
			}
		}

		return answer;
	}
}
