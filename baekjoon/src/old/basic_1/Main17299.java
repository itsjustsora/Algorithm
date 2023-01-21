package old.basic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main17299 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        int[] ans = new int[N];
        int[] count = new int[1000001];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            count[arr[i]] += 1;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            if (stack.isEmpty()) stack.push(i);
            // 현재 인덱스의 배열 값의 등장 횟수가 스택의 맨 위 요소보다 클 경우 동안 반복
            while (!stack.isEmpty() && count[arr[stack.peek()]] < count[arr[i]]) {
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        // 더 이상 비교할 값이 없이 남아있는 경우 -1
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}
