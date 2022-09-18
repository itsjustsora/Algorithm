package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main0103 {

    public static String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while((pos=str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();

            if(len > m) {
                m = len;
                answer = tmp;
            }
            str = str.substring(pos+1);
        }
        if(str.length() > m) answer = str;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(solution(str));
    }
}
