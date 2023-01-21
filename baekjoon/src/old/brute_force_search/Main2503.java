package old.brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main2503 {

    static int n;
    static List<Pair> input = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        n = N;

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int num = Integer.parseInt(line[0]);
            int strike = Integer.parseInt(line[1]);
            int ball = Integer.parseInt(line[2]);

            Pair pair = new Pair(num, strike, ball);
            input.add(pair);
        }
        System.out.println(call());
    }

    static int call() {
        int result = 0;

        for (int i = 123; i < 988; i++) {
            if (!check(i)) continue;

            int pass = 0;

            for (int j = 0; j < n; j++) {
                int strikeCount = 0;
                int ballCount = 0;

                Pair current = input.get(j);
                String currentNum = Integer.toString(current.num);
                String data = Integer.toString(i);

                for (int k = 0; k < 3; k++) {
                    if (currentNum.charAt(k) == data.charAt(k)) strikeCount++;
                }

                for (int h = 0; h < 3; h++) {
                    for (int u = 0; u < 3; u++) {
                        if (data.charAt(h) == currentNum.charAt(u)) {
                            if (h != u) ballCount++;
                        }
                    }
                }

                if (current.strike == strikeCount && current.ball == ballCount) {
                    pass++;
                }
            }
            if (pass == n) {
                result++;
            }
        }
        return result;
    }

    static boolean check(int num) {
        String standard = Integer.toString(num);

        if (standard.charAt(0) == standard.charAt(1)) {
            return false;
        }

        if (standard.charAt(1) == standard.charAt(2)) {
            return false;
        }

        if (standard.charAt(0) == standard.charAt(2)) {
            return false;
        }

        if (standard.charAt(0) == '0' || standard.charAt(1) == '0' || standard.charAt(2) == '0')
            return false;

        return true;
    }

    static class Pair {
        int num;
        int strike;
        int ball;

        Pair(int n, int s, int b) {
            this.num = n;
            this.strike = s;
            this.ball = b;
        }
    }
}
