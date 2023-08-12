package lv1;

import java.util.Stack;

public class 다트_게임 {
	public int solution(String dartResult) {
		Stack<Integer> stack = new Stack<>();
		int answer = 0;

		for (int i = 0; i < dartResult.length(); i++) {
			char ch = dartResult.charAt(i);
			if ('0' <= ch  && ch <= '9') {
				if (Character.isDigit(dartResult.charAt(i+1))) {
					stack.add(10);
					i++;
					continue;
				}
				stack.add(ch - '0');
			}
			else if (ch == 'S') {
				stack.add((int) Math.pow(stack.pop(), 1));
				continue;
			}
			else if (ch == 'D') {
				stack.add((int) Math.pow(stack.pop(), 2));
				continue;
			}
			else if (ch == 'T'){
				stack.add((int) Math.pow(stack.pop(), 3));
				continue;
			}
			else if (ch == '*') {
				int now = stack.pop();
				if (!stack.isEmpty()) {
					stack.add(stack.pop() * 2);
				}
				stack.add(now * 2);
				continue;
			}
			else if (ch == '#') {
				stack.add(stack.pop() * -1);
				continue;
			}
		}

		for (int score : stack) {
			answer += score;
		}

		return answer;
	}
}
