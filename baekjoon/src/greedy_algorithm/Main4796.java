package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String end = "0 0 0";

        int cnt = 1;
        while(true) {
            String lines = br.readLine();

            if (lines.equals(end)) break;

            String[] sep = lines.split(" ");

            int result = solution(Integer.parseInt(sep[0]), Integer.parseInt(sep[1]), Integer.parseInt(sep[2]));

            sb.append("Case ").append(cnt).append(": ").append(result).append("\n");
            cnt++;
        }
        System.out.println(sb);
    }

    public static int solution(int L, int P, int V) {
        int days = (V / P) * L;
        int restDays = V % P;
        int extraDays;

        if (restDays < L) extraDays = restDays;
        else extraDays = L;

        return days + extraDays;
    }
}
