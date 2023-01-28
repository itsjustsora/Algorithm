package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main17509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] pair = new int[11][2];

        for (int i = 0; i < 11; i++) {
            String[] lines = br.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                pair[i][j] = Integer.parseInt(lines[j]);
            }
        }

        Arrays.sort(pair, (Comparator.comparingInt(o -> o[0])));

        int penalty = 0;
        int currentTime = 0;
        for (int i = 0; i < 11; i++) {
            penalty += (currentTime + pair[i][0] + (20 * pair[i][1]));
            currentTime += pair[i][0];
        }
        System.out.println(penalty);
    }
}
