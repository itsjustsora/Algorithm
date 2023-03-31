package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main0501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String answer = "YES";

		Stack<Character> stack = new Stack<>();
		for (char ch : str.toCharArray()) {
			if (ch == '(') {
				stack.push('(');
			} else {
				if (stack.isEmpty()) {
					answer = "NO";
					break;
				}
				stack.pop();
			}
		}

		if (!stack.isEmpty()) answer = "NO";

		System.out.println(answer);
	}
}
