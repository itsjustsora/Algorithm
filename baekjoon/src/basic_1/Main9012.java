package basic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            sb.append(solution(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }

    public static String solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') stack.push('(');
            else if(stack.empty()) return "NO";
            else stack.pop();
        }

        if (stack.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
