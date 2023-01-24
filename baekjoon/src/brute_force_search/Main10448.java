package brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10448 {

    static int[] triNum = new int[45];

    public static void triangular_number() {
        for (int i = 1; i < 45; i++) {
            triNum[i] = i * (i + 1) / 2;
        }
    }

    public static boolean eureka(int N) {
        for (int i = 1; i < 45; i++) {
            for (int j = 1; j < 45; j++) {
                for (int k = 1; k < 45; k++) {
                    if (triNum[i] + triNum[j] + triNum[k] == N) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        triangular_number();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            if(eureka(N)) sb.append("1");
            else sb.append("0");

            sb.append("\n");
        }
        System.out.println(sb);
    }
}
