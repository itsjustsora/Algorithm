package practice.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main0109 {

    public static int solution(String str) {
        String answer="";

        for(char x : str.toCharArray()) {
            if(Character.isDigit(x)) answer += x;
        }
        return Integer.parseInt(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));

    }
}
