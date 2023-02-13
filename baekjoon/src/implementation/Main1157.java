package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        line = line.toLowerCase();

        int[] alphabet = new int[27];

        int max = 0;
        String answer = "?";
        int len = line.length();
        for (int i = 0; i < len; i++) {
            int num = line.charAt(i) - 97;
            alphabet[num]++;
            if (max < alphabet[num]) {
                max = alphabet[num];
                answer = String.valueOf(line.charAt(i)).toUpperCase();
            }
        }

        int cnt = 0;
        for (int i = 0; i < 27; i++) {
            if (max == alphabet[i]) cnt++;
        }

        System.out.println(cnt > 1 ? "?" : answer);





    }
}
