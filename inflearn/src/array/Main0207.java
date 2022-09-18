package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main0207 {

    public static int solution(int n, int[] arr) {
        int sum = 0, cnt = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] == 1) {
                cnt++;
                sum += cnt;
            }
            else cnt = 0;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        System.out.println(solution(n, arr));;
    }
}
