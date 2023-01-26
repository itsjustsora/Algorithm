package brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1018 {

    static int N, M;
    static int min = 64;
    static String[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        board = new String[N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }

        int sol = Integer.MAX_VALUE;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int curSol = getSolution(i, j);
                if (sol > curSol) sol = curSol;
            }
        }
        System.out.println(sol);

    }

    private static int getSolution(int n, int m) {
        String[] origin = { "WBWBWBWB", "BWBWBWBW" };
        int whiteSol = 0;

        for (int i = 0; i < 8; i++) {
            // 원래 board의 row 인덱스 값
            int row = n + i;
            for (int j = 0; j < 8; j++) {
                // 원래 board의 column 인덱스 값
                int col = m + j;
                // 비교 값에 데이터가 두 개이기 때문에 % 사용
                if (board[row].charAt(col) != origin[row % 2].charAt(j)) whiteSol++;
            }
        }
        // 블랙 체스판 변경 경우의 수 + 화이트 체스판 변경 경우의 수가 64이기 때문에
        // 두 번째 인자는 블랙으로 변경하려는 경우의 수이다.
        return Math.min(whiteSol, min - whiteSol);
    }
}
