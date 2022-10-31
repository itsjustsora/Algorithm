package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] square = new int[101][101];
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        int cnt = 0;

        for(int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for(int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    if (square[j][k] != 0) continue;
                    square[j][k] = 1;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
