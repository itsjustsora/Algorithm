package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < K; i++) {
			int N = Integer.parseInt(br.readLine());
			if (!stack.isEmpty()) {
				if (N == 0) {
					stack.pop();
					continue;
				}
			}
			stack.push(N);
		}

		int sum = 0;
		if (stack.isEmpty()) {
			sb.append(0);
		} else {
			while (!stack.isEmpty()) {
				sum += stack.pop();
			}
			sb.append(sum);
		}
		System.out.println(sum);
	}
}
