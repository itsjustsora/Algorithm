package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main0502 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String answer = "";

		Stack<Character> stack = new Stack<>();
		for (char ch : str.toCharArray()) {
			if (ch == ')') {
				while (stack.pop() != '(');
			} else stack.push(ch);
		}

		for (int i = 0; i < stack.size(); i++) {
			answer += stack.get(i);
		}

		System.out.println(answer);
	}
}
