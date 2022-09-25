package stage.ten_recurtion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1003 {

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            arr[i][0] = isPalindrom(br.readLine());
            arr[i][1] = count;
        }

        StringBuilder sb = new StringBuilder();
        for(int[] i : arr) {
            sb.append(i[0]).append(" ").append(i[1]).append("\n");
        }
        System.out.println(sb);



    }

    public static int isPalindrom(String s) {
        count = 0;
        return recursion(s, 0, s.length()-1);
    }

    public static int recursion(String s, int l, int r) {
        count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
}
