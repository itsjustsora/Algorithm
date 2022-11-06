package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4796 {

    public static int L, P, V;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true) {
           st = new StringTokenizer(br.readLine(), " ");
           L = Integer.parseInt(st.nextToken());
           P = Integer.parseInt(st.nextToken());
           V = Integer.parseInt(st.nextToken());
           if (L == 0 || P == 0 || V == 0) {
               break;
           }
            sb.append(solution()).append("\n");
        }
        System.out.println(sb);
    }

    public static String solution() {
        String answer = "";
        int result = 0;

        result = (V / P * L);
        if (V % P <= L) {
            result += V % P;
        } else {
            result += L;
        }

        answer = "Case "  + ++cnt + ": " + result;
        return answer;
    }
}
