package old.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int leakCnt = Integer.parseInt(st.nextToken());
        int tapeLength = Integer.parseInt(st.nextToken());

        int tapeCnt = 0;
        int[] arr = new int[leakCnt];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int tapeRange = (int) (arr[0] - 0.5 + tapeLength);
        tapeCnt++;

        for (int i = 1; i < arr.length; i++) {
            if (tapeRange < (int)(arr[i] + 0.5)) {
                tapeRange = (int)(arr[i] - 0.5 + tapeLength);
                tapeCnt++;
            }
        }

        System.out.println(tapeCnt);
    }
}
