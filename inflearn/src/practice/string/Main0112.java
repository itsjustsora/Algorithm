package practice.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main0112 {

    public static String solution(int num, String str) {
        String answer = "";

        for(int i = 0; i < num; i++) {
            String tmp = str.substring(0, 7).replace("#", "1").replace("*", "0");
            int result = Integer.parseInt(tmp, 2);
            answer += (char)result;
            str = str.substring(7);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.println(solution(num, str));
    }
}
