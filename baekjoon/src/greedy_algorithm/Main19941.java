package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main19941 {

    static boolean[] hamburgers;
    static String positions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = br.readLine().split(" ");

        int N = Integer.parseInt(lines[0]); // 식탁의 길이
        int K = Integer.parseInt(lines[1]); // 햄버거를 선택할 수 있는 거리

        positions = br.readLine();

        hamburgers = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (positions.charAt(i) == 'P') {
                int start = Math.max(i - K, 0);
                int end = Math.min(i + K, N-1);
                solution(start, end);
            }

        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (hamburgers[i]) cnt++;
        }
        System.out.println(cnt);


    }

    private static void solution(int n, int m) {
        for (int i = n; i <= m; i++) {
            if (positions.charAt(i) == 'H' && !hamburgers[i]) {
                hamburgers[i] = true;
                break;
            }
        }
    }
}
