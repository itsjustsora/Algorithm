package stage.nine_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main0910_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder[] p = new StringBuilder[201];

        // 객체 배열 인덱스에 StringBuilder 객체를 각각 만들어줌.
        for(int i = 0; i < p.length; i++) {
            p[i] = new StringBuilder();
        }

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            p[age].append(age).append(" ").append(name).append("\n");
        }

        StringBuilder sb = new StringBuilder();
        for(StringBuilder val : p) {
            sb.append(val);
        }
        System.out.println(sb);


    }
}
