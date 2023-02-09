package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * int, long 자료형을 유의하자!
 */
public class Main1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int peopleCnt = Integer.parseInt(br.readLine());

        Integer[] tips = new Integer[peopleCnt];
        for (int i = 0; i < peopleCnt; i++) {
            tips[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(tips, Collections.reverseOrder());
        long sum = 0;
        for (int i = 0; i < peopleCnt; i++) {
            int money = (tips[i] - ((i + 1) - 1));
            if (money > 0) {
                sum += money;
            }
        }
        System.out.println(sum);
    }
}
