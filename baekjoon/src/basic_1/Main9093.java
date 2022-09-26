package basic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 1. StringBuilder의 reverse() 활용
        /*StringBuilder result = new StringBuilder();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                StringBuilder sb = new StringBuilder(st.nextToken());
                result.append(sb.reverse()).append(" ");
            }
            result.append("\n");
        }
        System.out.println(result);
        */

        // 2. Stack
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                String str = st.nextToken();
                for(char ch : str.toCharArray()) {
                    stack.push(ch);
                }
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
