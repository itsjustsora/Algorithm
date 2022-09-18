package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main0110 {

    public static int[] solution(String s, char t) {
        int[] answer = new int[s.length()];
        int p = 1000;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == t) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }
        p = 1000;
        for(int i = s.length()-1; i>=0; i--) {
            if(s.charAt(i)==t) p=0;
            else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        String s = st.nextToken();
        char ch = st.nextToken().charAt(0);

        for(int x : solution(s, ch)) {
            System.out.print(x + " ");
        }
    }
}
