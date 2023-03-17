package lv2;

import java.util.Stack;

public class 짝지어_제거하기 {
	// Stack
	public int solution(String s)
	{
		char[] chs = s.toCharArray();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < chs.length; i++) {
			char c = chs[i];
			if (stack.isEmpty()) stack.push(c);
			else {
				if (stack.peek() == c) {
					stack.pop();
				} else {
					stack.push(c);
				}
			}
		}
		return stack.isEmpty() ? 1 : 0;
	}
}
