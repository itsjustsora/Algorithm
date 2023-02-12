package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main20365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String colors = br.readLine();

        int BCnt = 0;
        int RCnt = 0;
        for (int i = 0; i < N; i++) {
            char ch = colors.charAt(i);
            if (i == 0) {
                if (ch == 'B') BCnt++;
                else RCnt++;
            }
            else {
                if (colors.charAt(i - 1) == ch) continue;
                else {
                    if (ch == 'B') BCnt++;
                    else RCnt++;
                }
            }
        }

        int sum = 0;
        if (BCnt > RCnt) {
            sum = RCnt + 1;
        } else {
            sum = BCnt + 1;
        }
        System.out.println(sum);
    }
}
