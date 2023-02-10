package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main20300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        long[] loss = new long[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            loss[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(loss);

        ArrayDeque<Long> dq = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            dq.add(loss[i]);
        }


        long max = 0;
        if (size % 2 == 1) {
            max = dq.pollLast();
        }

        int len = dq.size();
        for (int i = 0; i < (len / 2); i++) {
            max = Math.max(max, (dq.pollFirst() + dq.pollLast()));
        }
        System.out.println(max);
    }
}
