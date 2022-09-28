package basic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        Queue<Integer> que = new LinkedList<>();

        for(int i = 1; i < N+1; i++) {
            que.offer(i);
        }

        sb.append("<");
        while (!que.isEmpty()) {
            for(int i = 0; i < K; i++) {
                if(i == K-1) {
                    sb.append(que.poll());
                    if(!que.isEmpty()) sb.append(", ");
                } else {
                    que.offer(que.poll());
                }
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
