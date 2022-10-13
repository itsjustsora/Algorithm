package twoPointers_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main0303 {

    public static int solution(int[] arr, int K) {
        int max = 0, sum = 0;
        for(int i = 0; i < K; i++) {
            sum += arr[i];
            max = sum;
        }

        for(int i = K; i < arr.length; i++) {
           sum += (arr[i] - arr[i-K]);
           max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] number = br.readLine().split(" ");
        int K = Integer.parseInt(number[1]);

        String[] str = br.readLine().split(" ");
        int[] arr = new int[str.length];

        for(int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        System.out.println(solution(arr, K));

    }
}
