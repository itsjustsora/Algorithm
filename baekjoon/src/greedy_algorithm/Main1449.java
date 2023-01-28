package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = br.readLine().split(" ");

        int N = Integer.parseInt(lines[0]);
        int L = Integer.parseInt(lines[1]);

        int cnt = 0;
        int[] arr = new int[N];
        String[] distance = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(distance[i]);
        }

        int range = (int) (arr[0] - 0.5 + L);
        cnt++;

        Arrays.sort(arr);

        for (int i = 1; i < N; i++) {
            if (range < (int) (arr[i] + 0.5)) {
                range = (int) (arr[i] - 0.5 + L);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
