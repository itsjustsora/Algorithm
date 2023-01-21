package old.stage.seven_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main0701 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        int C = Integer.parseInt(str[2]);

        if (C <= B) {
            System.out.println("-1");
        } else {
            System.out.println((A/(C-B)) + 1);
        }

    }
}
