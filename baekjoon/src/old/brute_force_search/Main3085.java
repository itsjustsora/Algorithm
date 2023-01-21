package old.brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String colors = br.readLine();
            System.out.println("colors = " + colors);
            for (int j = 0; j < N; j++) {
                arr[i][j] = colors.charAt(j);
                System.out.println("colors.charAt(j) = " + colors.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (arr[i][j - 1] != arr[i][j]) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
