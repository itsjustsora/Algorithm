package stage.nine_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main0904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];

        while(st.hasMoreTokens()) {
           for(int i = 0; i < n; i++) {
               arr[i] = Integer.parseInt(st.nextToken());
           }
        }

        Arrays.sort(arr);

        System.out.println(arr[n-k]);

    }
}
