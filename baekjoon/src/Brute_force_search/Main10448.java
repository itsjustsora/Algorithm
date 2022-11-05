package Brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10448 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] triNum = new int[45];

        for(int i = 1; i < 45; i++) {
            triNum[i] = i * (i + 1) / 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            int result = eureka(n, triNum);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static int eureka(int N, int[] triNum) {
        for (int i = 1; i < 45; i++) {
            for (int j = 1; j < 45; j++) {
                for (int k = 1; k < 45; k++) {
                    int sum = triNum[i] + triNum[j] + triNum[k];
                    if (sum == N) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
