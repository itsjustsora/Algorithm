package practice.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main0203 {

    public static String solution(int[] A, int[] B, int num) {
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < num; i++) {
            if (A[i] == B[i]) answer.append("D");
            else if (A[i] == 1 && B[i] == 3) answer.append("A");
            else if (A[i] == 2 && B[i] == 1) answer.append("A");
            else if (A[i] == 3 && B[i] == 2) answer.append("A");
            else answer.append("B");

        }
        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] strA = br.readLine().split(" ");
        String[] strB = br.readLine().split(" ");

        int[] A = new int[num];
        int[] B = new int[num];

        for (int i = 0; i < num; i++) {
            A[i] = Integer.parseInt(strA[i]);
            B[i] = Integer.parseInt(strB[i]);
        }

        for(char ch : solution(A, B, num).toCharArray()) {
            System.out.println(ch);
        }
    }
}
