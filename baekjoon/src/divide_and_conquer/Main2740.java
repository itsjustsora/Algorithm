package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2740 {

    public static int[][] A;
    public static int[][] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = br.readLine().split(" ");

        int rowA = Integer.parseInt(lines[0]);
        int colA = Integer.parseInt(lines[1]);

        A = new int[rowA][colA];
        for (int i = 0; i < rowA; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < colA; j++) {
                A[i][j] = Integer.parseInt(str[j]);
            }
        }

        String[] lines2 = br.readLine().split(" ");

        int rowB = Integer.parseInt(lines2[0]);
        int colB = Integer.parseInt(lines2[1]);

        B = new int[rowB][colB];
        for (int i = 0; i < rowB; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < colB; j++) {
                B[i][j] = Integer.parseInt(str[j]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                int sum = 0;
                for (int k = 0; k < rowB; k++) {
                    sum += A[i][k] * B[k][j];
                }
                sb.append(sum).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
