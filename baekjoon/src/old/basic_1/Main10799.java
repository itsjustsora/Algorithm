package old.basic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push(i);
                continue;
            }

            if (str.charAt(i) == ')') {
                stack.pop();
                if(str.charAt(i - 1) == '(') {
                    count += stack.size();
                } else {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
