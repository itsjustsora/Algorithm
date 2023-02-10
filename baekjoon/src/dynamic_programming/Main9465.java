package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[T][N + 1];
            int[][] dp = new int[T][N + 1];

            for (int j = 0; j < T; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k < N + 1; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int k = 2; k < N + 1; k++) {
                dp[0][k] = Math.max(dp[1][k - 1], dp[1][k - 2]) + arr[0][k];
                dp[1][k] = Math.max(dp[0][k - 1], dp[0][k - 2]) + arr[1][k];
            }
            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}
