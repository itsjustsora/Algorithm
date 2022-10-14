package twoPointers_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main0304 {

    public static int solution(int[] nums, int M) {
        int answer = 0, sum = 0, lt = 0;
        for(int rt = 0; rt < nums.length; rt++) {
            sum += nums[rt];
            if(sum == M) answer++;
            while(sum >= M) {
                sum -= nums[lt++];
                if(sum == M) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);

        String[] str = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        System.out.println(solution(arr, M));

    }
}
