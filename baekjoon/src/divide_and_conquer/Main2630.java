package divide_and_conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2630 {

    public static int white = 0;
    public static int blue = 0;
    public static int[][] paper;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] lines = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(lines[j]);
            }
        }

        divide(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void divide(int N, int M, int size) {
       if (colorCheck(N, M, size)) {
           if (paper[N][M] == 0) {
               white++;
           } else {
               blue++;
           }
           return;
       }

       int newSize = size / 2;

       divide(N, M, newSize);                               // 2사분면
       divide(N, M + newSize, newSize);                 // 1사분면
       divide(N + newSize, M, newSize);                 // 3사분면
       divide(N + newSize, M + newSize, newSize);   // 4사분기
    }

    private static boolean colorCheck(int n, int m, int size) {

        // 첫 번째 원소를 기준으로 검사
        int color = paper[n][m];

        for (int i = n; i < n + size; i++) {
            for (int j = m; j < m + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;

    }
}
