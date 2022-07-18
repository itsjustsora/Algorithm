package practice.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main0102 {

    public static String solution(String str) {
        String answer = "";

        for(char ch : str.toCharArray()) {
            if(ch >= 97 && ch <= 122) answer+=(char)(ch-32);
            else answer+=(char)(ch+32);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(solution(str));
    }
}
