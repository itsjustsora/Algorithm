package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] drinks = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            drinks[i] = Integer.parseInt(st.nextToken());
            if (drinks[i] > max) {
                max = drinks[i];
            }
        }

        double sum = max;
        for (int i = 0; i < N; i++) {
            if (drinks[i] == max) continue;
            sum += drinks[i] / 2.0;
        }
        System.out.println(sum);

    }
}
