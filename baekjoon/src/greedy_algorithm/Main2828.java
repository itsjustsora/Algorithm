package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = br.readLine().split(" ");

        int M = Integer.parseInt(lines[1]);
        int j = Integer.parseInt(br.readLine());

        int left = 1;
        int right = M;

        int move = 0;
        for (int i = 0; i < j; i++) {
            int point = Integer.parseInt(br.readLine());

            if (left <= point && point <= right) {
                continue;
            }

            if (point > right) {
                move += point - right;
                left += point - right;
                right = point;
            } else {
                move += left - point;
                right -= left - point;
                left = point;
            }
        }
        System.out.println(move);

    }
}
