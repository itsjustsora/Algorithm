package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main0504 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		System.out.println(solution(str));
	}

	private static int solution(String str) {
		Stack<Integer> stack = new Stack<>();
		for (char ch : str.toCharArray()) {
			if (Character.isDigit(ch)) {
				stack.push(ch - '0');
			} else {
				char operator = ch;
				int rt = stack.pop();
				int lt = stack.pop();

				stack.push(operation(lt, rt, operator));
			}
		}
		return stack.get(0);
	}

	private static int operation(int num1, int num2, char operator) {
		int answer = 0;
		switch (operator) {
			case '+':
				answer = num1 + num2;
				break;
			case '-':
				answer = num1 - num2;
				break;
			case '*':
				answer = num1 * num2;
				break;
			case '/':
				answer = num1 / num2;
				break;
		}
		return answer;
	}
}
