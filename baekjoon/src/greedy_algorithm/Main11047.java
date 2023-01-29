package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = br.readLine().split(" ");

        int N = Integer.parseInt(lines[0]);
        int total = Integer.parseInt(lines[1]);

        Integer[] coins = new Integer[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins, Collections.reverseOrder());
        int cnt = 0;
        for (int i = 0; i < N; i++)  {
            if (coins[i] <= total) {
                cnt += (total / coins[i]);
                total = total % coins[i];
            }
        }
        System.out.println(cnt);
    }
}
