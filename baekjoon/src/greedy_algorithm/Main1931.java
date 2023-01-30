package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] times = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] lines = br.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                times[i][j] = Integer.parseInt(lines[j]);
            }
        }

        Arrays.sort(times, ((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        }));

        int cnt = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            if (end <= times[i][0]) {
                end = times[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
