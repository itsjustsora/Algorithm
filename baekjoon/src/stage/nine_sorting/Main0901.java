package stage.nine_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main0901 {

    /**
     * 시간 복잡도가 O(n²)인 정렬 알고리즘 이용하기
     * 삽입 정렬, 거품 정렬
     **/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[2001];

        for(int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine()) + 1000] = true;
        }

        for(int i = 0; i < 2001; i++) {
            if(arr[i]) {
                System.out.println(i - 1000);
            }
        }
    }
}
