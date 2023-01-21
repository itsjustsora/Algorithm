package old.stage.ten_recurtion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1005 {

    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        star(0, 0, N, false);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void star(int x, int y, int N, boolean blank) {
        // 공백 칸일 때는 공백 채우기
        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        // 더이상 쪼갤 수 없는 블록일 때
        if (N == 1) {
            System.out.println("x, y = " + x + " , " + y);
            arr[x][y] = '*';
            return;
        }

        /**
         * N이 9일 때 한 블록의 사이즈가 3이니까
         */
        int size = N / 3;
        int count = 0;
        for (int i = x; i < x +N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;
                if (count == 5) { // 공백 칸일 때
                    star(i, j, size, true);
                } else {
                    star(i, j, size, false);
                }
            }
        }
    }
}
