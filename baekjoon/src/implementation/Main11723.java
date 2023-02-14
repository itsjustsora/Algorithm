package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11723 {

    public static Set<Integer> set = new HashSet<>();
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();
            int num = 0;
            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }
            solution(operator, num);

            if ("check".equals(operator)) {
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void solution(String operator, int num) {
        answer = 0;

        switch (operator) {
            case "add":
                if (set.contains(num)) break;
                set.add(num);
                break;
            case "remove":
                if (!set.contains(num)) break;
                set.remove(num);
                break;
            case "check":
                if (set.contains(num)) answer = 1;
                break;
            case "toggle":
                if (set.contains(num)) set.remove(num);
                else set.add(num);
                break;
            case "all":
                set.clear();
                List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
                set.addAll(list);
                break;
            case "empty":
                set.clear();
                break;

        }
    }
}
