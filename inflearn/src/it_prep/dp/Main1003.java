package it_prep.dp;

import java.io.IOException;
import java.util.Scanner;

/**
 * 계단 오르기 (BOJ 2579)
 * i 계단에 올랐을 때 얻을 수 있는 최댓값
 */
class Main1003 {

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        int[] score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = kb.nextInt();
        }

        int[] dy = new int[n + 1];
        dy[1] = score[1];
        if (n > 1) dy[2] = score[1] + score[2];

        for (int i = 3; i <= n; i++) {
            dy[i] = Math.max(dy[i - 2], dy[i - 3] + score[i-1]) + score[i];
        }

        System.out.println(dy[n]);

    }
}