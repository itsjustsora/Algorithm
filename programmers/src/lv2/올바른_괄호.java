package lv2;

import java.util.Stack;

public class 올바른_괄호 {
	boolean solution(String s) {
		if (s.charAt(0) == ')' || s.isEmpty()) return false;

		boolean answer = false;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') stack.add(s.charAt(i));
			else if (s.charAt(i) == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}

		}
		return stack.isEmpty();
	}
}
