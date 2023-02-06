package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1992 {

    public static int[][] board;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String lines = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = lines.charAt(j) - '0';
            }
        }

        divide(0, 0, N);
        System.out.println(sb);
    }

    private static void divide(int N, int M, int size) {
        if (numberCheck(N, M, size)) {
           sb.append(board[N][M]);
           return;
        }

        int newSize = size / 2;

        sb.append("(");

        divide(N, M, newSize);
        divide(N, M + newSize, newSize);
        divide(N + newSize, M, newSize);
        divide(N + newSize, M + newSize, newSize);

        sb.append(")");
    }

    private static boolean numberCheck(int N, int M, int size) {
        int number = board[N][M];

        for (int i = N; i < N + size; i++) {
            for (int j = M; j < M + size; j++) {
                if (board[i][j] != number) {
                    return false;
                }
            }
        }
        return true;
    }
}
