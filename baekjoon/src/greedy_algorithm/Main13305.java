package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] distance = new long[N - 1];
        String[] dis = br.readLine().split(" ");
        for (int i = 0; i < N -1; i++) {
            distance[i] = Long.parseLong(dis[i]);
        }

        long[] price = new long[N];
        String[] pri = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            price[i] = Long.parseLong(pri[i]);
        }


        long sum = 0;
        long min = price[0];
        for (int i = 0; i < N - 1; i++) {
            if (price[i] < min) {
                min = price[i];
            }
            sum += distance[i] * min;
        }
        System.out.println(sum);

    }
}
