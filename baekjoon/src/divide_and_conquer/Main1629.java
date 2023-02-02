package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = br.readLine().split(" ");

        long A = Long.parseLong(lines[0]);
        long B = Long.parseLong(lines[1]);
        long C = Long.parseLong(lines[2]);

        System.out.println(pow(A, B, C));

    }

    private static long pow(long A, long B, long C) {
        if(B == 1) {
            return A % C;
        }

        long temp = pow(A, B / 2, C);

        if (B % 2 == 1) {
            return (temp * temp % C) * A % C;
        }
        return temp * temp % C;
    }
}
