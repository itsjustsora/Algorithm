package it_prep.dp;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 등차수열 (BOJ 1994 )
 * 등차수열의 최대 길이
 */
class Main1004 {

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int answer = 0;

        if (n == 1) {
            System.out.println(1);
            return;
        } else {
            int[] nums = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                nums[i] = kb.nextInt();
            }
            Arrays.sort(nums);

            int[][] dy = new int[n + 1][n + 1];

            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    dy[i][j] = 2;

                    int pre = 2 * nums[i] - nums[j];
                    int k = 0;
                    for (k = i - 1; k >= 1; k--) {
                        if (nums[k] == pre) break;
                    }

                    dy[i][j] = Math.max(dy[i][j], dy[k][i] + 1);
                    answer = Math.max(answer, dy[i][j]);
                }
            }
        }

        System.out.println(answer);
    }
}