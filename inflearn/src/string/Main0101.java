package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main0101 {

    public static int solution(String str, char ch) {
        int cnt = 0;
        str = str.toUpperCase(Locale.ROOT);
        ch = Character.toUpperCase(ch);

        for(char c : str.toCharArray()) {
            if(c == ch) cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        char ch = br.readLine().charAt(0);

        System.out.println(solution(S, ch));
    }

}
