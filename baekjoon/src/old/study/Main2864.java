package old.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        String A = input[0];
        String B = input[1];

        StringBuilder minA = new StringBuilder();
        StringBuilder maxA = new StringBuilder();
        StringBuilder minB = new StringBuilder();
        StringBuilder maxB = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '5') {
                maxA.append("6");
            } else {
                maxA.append(A.charAt(i));
            }

            if (A.charAt(i) == '6') {
                minA.append("5");
            } else {
                minA.append(A.charAt(i));
            }
        }

        for (int i = 0; i < B.length(); i++) {
            if (B.charAt(i) == '5') {
                maxB.append("6");
            } else {
                maxB.append(B.charAt(i));
            }

            if (B.charAt(i) == '6') {
                minB.append("5");
            } else {
                minB.append(B.charAt(i));
            }
        }

        int min = Integer.parseInt(minA.toString()) + Integer.parseInt(minB.toString());
        int max = Integer.parseInt(maxA.toString()) + Integer.parseInt(maxB.toString());
        System.out.println(min + " " + max);
    }
}
