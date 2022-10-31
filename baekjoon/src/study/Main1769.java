package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        String answer = "NO";
        int cnt = 0;

        while (num.length() != 1) {
            int sum = 0;
            for(char ch : num.toCharArray()) {
                sum += ch - '0';
            }
            num = Integer.toString(sum);
            cnt++;
        }

        if (Integer.parseInt(num) % 3 == 0) answer = "YES";

        System.out.println(cnt + "\n" + answer);
    }
}
