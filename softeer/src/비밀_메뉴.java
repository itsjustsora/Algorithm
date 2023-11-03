package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 비밀_메뉴 {
	// Sting contains()를 활용하면 훨씬 간단하게 풀이 가능
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String answer = "normal";

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Stack<Integer> stack = new Stack<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			stack.push(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		int base = stack.pop();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num > k) {
				break;
			}

			if (base == num && !stack.isEmpty()) {
				base = stack.pop();
			}
		}

		if (stack.isEmpty()) {
			answer = "secret";
		}
		System.out.println(answer);
	}
}
