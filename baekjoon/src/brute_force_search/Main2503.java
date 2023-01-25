package brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2503 {

    private static boolean check[] = new boolean[988];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            cal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        for (int i = 123; i < 988; i++) {
            if (!check[i]) cnt++;
        }
        System.out.println(cnt);
    }

    private static void cal(int num, int strike, int ball) {
        int a = num / 100;
        int b = num % 100 / 10;
        int c = num % 100 % 10;

        for (int i = 123; i < 988; i++) {
            if (check[i]) continue;

            int st = 0;
            int ba = 0;

            int first = i / 100;
            int second = i % 100 / 10;
            int third = i % 100 % 10;

            if (second == 0 || third == 0 || first == second || first == third || third == second) {
                check[i] = true;
                continue;
            }

            int[] origin = {a, b, c};
            int[] arr = { first, second, third };

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (arr[j] == origin[k]) {
                        if (j == k) {
                            st++;
                            continue;
                        }
                        ba++;
                    }
                }
            }

            if (strike != st || ball != ba) {
                check[i] = true;
            }
        }
    }
}
