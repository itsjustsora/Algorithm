package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = br.readLine().split("-");

        int len = lines.length;
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int temp = 0;

            String[] add = lines[i].split("\\+");
            for (int j = 0; j < add.length; j++) {
                temp += Integer.parseInt(add[j]);
            }

            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
