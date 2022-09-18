package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main0205 {

    public static int solution(int num) {
        int cnt = 0;
        int[] ch = new int[num+1];
        for (int i = 2; i < num+1; i++) {
            if (ch[i] == 0) {
                cnt++;
                for (int j = i; j <= num; j=j+i)  ch[j] = 1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        System.out.println(solution(num));
    }
}
