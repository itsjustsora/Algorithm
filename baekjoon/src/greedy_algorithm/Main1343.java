package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1343 {

    static StringBuilder sb = new StringBuilder();
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();

        cnt = 0;
        boolean flag = false;
        for (int i = 0; i < board.length(); i++) {
            char[] ch = board.toCharArray();
            if (ch[i] == '.') {
                if (cnt % 2 == 1) {
                    flag = true;
                    break;
                }
                solution();
                sb.append(".");
            } else {
                cnt++;
            }
        }

        if (cnt > 0) {
            if (flag || cnt % 2 == 1) {
                sb = new StringBuilder();
                sb.append("-1");
            } else {
                solution();
            }
        }

        System.out.println(sb);
    }

    private static void solution() {
        while (cnt > 0) {
            if (cnt >= 4) {
                sb.append("AAAA");
                cnt -= 4;
            } else {
                sb.append("BB");
                cnt -= 2;
            }
        }
    }
}
