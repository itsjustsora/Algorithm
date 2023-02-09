package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main11508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Integer[] prices = new Integer[num];
        for (int i = 0; i < num; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(prices, Collections.reverseOrder());

        long sum = 0;
        for (int i = 0; i < num; i++) {
            if ((i + 1) % 3 != 0) {
                sum += prices[i];
            }
        }
        System.out.println(sum);


    }
}
