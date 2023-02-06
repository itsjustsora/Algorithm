package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14916 {

    static final int five = 5;
    static final int two = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int change = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (change > 0) {
            if (change % five == 0) {
                cnt += change / five;
                break;
            }
            change -= two;
            cnt++;
        }

        if (change < 0) {
            cnt = -1;
        }

        System.out.println(cnt);
    }
}
