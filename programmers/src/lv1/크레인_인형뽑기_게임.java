package lv1;

import java.util.Stack;

public class 크레인_인형뽑기_게임 {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0 ; i < moves.length; i++) {
			int num = moves[i] - 1;
			for (int j = 0; j < board[0].length; j++) {
				int now = board[j][num];
				if (now > 0) {
					if (stack.isEmpty()) {
						stack.push(now);
						board[j][num] = 0;
					}
					else if (stack.peek() == now) {
						answer += 2;
						stack.pop();
					}
					else {
						stack.push(now);
					}
					board[j][num] = 0;
					break;
				}
			}
		}
		return answer;
	}
}
