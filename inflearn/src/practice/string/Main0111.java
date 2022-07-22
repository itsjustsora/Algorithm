package practice.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main0111 {

    public static String solution(String str) {
        int cnt = 1;
        str = str + " ";
        String answer = "";

        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) cnt++;
            else {
                answer += str.charAt(i);
                if (cnt > 1) answer += String.valueOf(cnt);
                cnt = 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }
}
