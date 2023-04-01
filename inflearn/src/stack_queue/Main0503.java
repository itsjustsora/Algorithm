package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main0503 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] moves = new int[M];
		for (int i = 0; i < M; i++) {
			moves[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(N, board, moves));
	}

	private static int solution(int n, int[][] board, int[] moves) {
		int answer = 0;

		Stack<Integer> stack = new Stack<>();
		for (int pos : moves) {
			for (int i = 0; i < n; i++) {
				if (board[i][pos-1] != 0) {
					int temp = board[i][pos-1];
					board[i][pos-1] = 0;
					if (!stack.isEmpty() && temp == stack.peek()) {
						answer += 2;
						stack.pop();
					}
					else stack.push(temp);
					break;
				}
			}
		}

		return answer;
	}
}
