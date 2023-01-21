package old.stage.eight_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main0805 {

    /**
     * 베르트랑 공준
     * 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는
     * 적어도 하나 존재한다.
     */

    public static boolean[] prime = new boolean[246913];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        get_prime();

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            int count = 0;

            for (int i = n + 1; i <= 2 * n; i++) {
                if(!prime[i]) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void get_prime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
