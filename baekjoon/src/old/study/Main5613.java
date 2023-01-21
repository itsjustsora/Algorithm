package old.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        while (true) {
            String operation = br.readLine();
            if (operation.equals("=")) break;

            switch (operation) {
                case "+":
                    num += Integer.parseInt(br.readLine());
                    break;
                case "-":
                    num -= Integer.parseInt(br.readLine());
                    break;
                case "*":
                    num *= Integer.parseInt(br.readLine());
                    break;
                case "/":
                    num /= Integer.parseInt(br.readLine());
                    break;
            }
        }

        System.out.println(num);
    }
}
