package stage.seven_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main0703 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int i = 1; // 대각선 행
        int sum = 0; // 해당 대각선 행까지 범위 안에 있는 칸의 수
        int top = 1, bot = 1;

        // 대각선 행과 칸의 수 구하기
        while(true) {
            sum += i;
            // 만약 칸의 수가 전달 받은 숫자보다 크거나 같으면 break
            if (N <= sum) {
                break;
            }
            i++;
        }

        if (i % 2 == 0) { // 짝수 행이면 대각선 아래로 내려감
            for(int j = 0; j <= sum - N; j++) {
                top = i - j;
                bot = j + 1;
            }
        } else {
            for(int j = 0; j <= sum - N; j++) {
                top = j + 1;
                bot = i - j;
            }
        }
        System.out.println(top + "/" + bot);

    }
}
