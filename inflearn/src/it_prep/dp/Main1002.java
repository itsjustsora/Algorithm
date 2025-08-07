package it_prep.dp;

import java.io.IOException;
import java.util.Scanner;

/**
 * 수도배관공사 (BOJ 2073)
 * i 길이의 수도관을 만들었을 때 최대 용량
 */
class Main1002 {

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        int distance = kb.nextInt();
        int p =  kb.nextInt();

        int[] dy = new int[distance + 1];

        for (int i = 0; i < p; i++) {
            int l =  kb.nextInt();
            int c =  kb.nextInt();

            for (int j = distance; j > l; j--) {
                if (dy[j-l] == 0) continue;
                dy[j] = Math.max(dy[j], Math.min(dy[j-l], c));
            }
            dy[l] = Math.max(dy[l], c);
        }

        System.out.println(dy[distance]);

    }
}