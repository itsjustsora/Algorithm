package twoPointers_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main0305 {

    public static int solution(int N) {
        int lt = 0, sum = 0, answer = 0;
        int m = N / 2 + 1;
        int[] arr = new int[m];

        for(int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }

        for(int rt = 0; rt < m; rt++) {
            sum+= arr[rt];
            if(sum == N) answer++;
            while(sum >= N) {
                sum -= arr[lt++];
                if(sum == N) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));

    }
}
