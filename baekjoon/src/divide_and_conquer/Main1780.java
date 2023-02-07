package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1780 {

    public static int[][] paper;
    public static int minus = 0;
    public static int zero = 0;
    public static int one = 0;
    public static void main(String[] args) throws IOException {
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

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);

    }

    private static void divide(int N, int M, int size) {
        if (checkNumber(N, M, size)) {
            if (paper[N][M] == 0) {
                zero++;
            } else if (paper[N][M] == 1) {
                one++;
            } else {
                minus++;
            }
            return;
        }

        int newSize = size / 3;

        divide(N, M, newSize);
        divide(N, M + newSize, newSize);
        divide(N, M + 2 * newSize, newSize);

        divide(N + newSize, M, newSize);
        divide(N + newSize, M + newSize, newSize);
        divide(N + newSize, M + 2 * newSize, newSize);

        divide(N + 2 * newSize, M, newSize);
        divide(N + 2 * newSize, M + newSize, newSize);
        divide(N + 2 * newSize, M + 2 * newSize, newSize);
    }

    private static boolean checkNumber(int n, int m, int size) {
        int number = paper[n][m];

        for (int i = n; i < n + size; i++) {
            for (int j = m; j < m + size; j++) {
                if (number != paper[i][j]) return false;
            }
        }

        return true;
    }
}
