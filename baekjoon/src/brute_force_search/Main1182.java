package brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1182 {

    public static int N, S;
    public static int cnt = 0;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution(0, 0);
        System.out.println(S == 0 ? cnt - 1 : cnt);
    }

    public static void solution(int start, int sum) {
        if (start == N) {
            if (sum == S) {
                cnt++;
            }
            return;
        }
        solution(start + 1, sum + arr[start]);
        solution(start + 1, sum);
    }
}
