package practice.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main0202 {

    public static int solution(int num, int[] arr) {
        int cnt = 1, max = arr[0];

        for(int i = 1; i < num; i++) {
            if (max < arr[i]) {
                cnt++;
                max = arr[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        System.out.println(solution(num, arr));
    }
}
