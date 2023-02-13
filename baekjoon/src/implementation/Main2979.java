package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] info = new int[3][2];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
                if (max < info[i][j]) max = info[i][j];
                if (min > info[i][j]) min = info[i][j];
            }
        }

        int[] park = new int[100];
        for (int i = 0; i < 3; i++) {
            int start = info[i][0];
            int end = info[i][1];
            for (int k = start; k < end; k++) {
                park[k]++;
            }
        }

        int sum = 0;
        for (int i = min; i < max; i++) {
            if (park[i] == 1) {
                sum += park[i] * A;
            } else if (park[i] == 2) {
                sum += park[i] * B;
            } else if (park[i] == 3){
                sum += park[i] * C;
            }
        }
        System.out.println(sum);
    }
}
