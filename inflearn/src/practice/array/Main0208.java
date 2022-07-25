package practice.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main0208 {

    private static int[] solution(int n, int[] arr) {
        int[] answer = new int[n];

        for(int i = 0; i < n; i++) {
            int cnt = 1;
            for(int j = 0; j < n; j++) {
                if(arr[j] > arr[i]) cnt++;
            }
            answer[i] = cnt;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        for(int t : solution(n, arr)) {
            System.out.print(t + " ");
        }
    }
}
