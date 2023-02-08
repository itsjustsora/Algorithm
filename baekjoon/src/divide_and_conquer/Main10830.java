package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10830 {

    public static int MOD = 1000;
    public static int[][] matrix;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");

        N = Integer.parseInt(info[0]); // 행렬의 크기
        long B = Long.parseLong(info[1]); // 제곱

        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] matrixArr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(matrixArr[j]) % MOD;
            }
        }

        int[][] result = square(matrix, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static int[][] square(int[][] A, long exponent) {
        if (exponent == 1L) {
            return A;
        }

        int[][] ret = square(A, exponent / 2);

        ret = multiply(ret, ret);

        // 지수가 홀수일 때 자기 자신을 한 번 더 곱해준다.
        if (exponent % 2 == 1L) {
            ret = multiply(ret, matrix);
        }

        return ret;
    }

    private static int[][] multiply(int[][] o1, int[][] o2) {
        int[][] ret = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }
        return ret;
    }
}
