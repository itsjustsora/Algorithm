package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] times = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] lines = br.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                times[i][j] = Integer.parseInt(lines[j]);
            }
        }

        Arrays.sort(times, ((o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(times[0][1]);

        // 이미 강의실에 첫 번째 강의를 배정했으니 1부터 시작
        for (int i = 1; i < N; i++) {
            if (queue.peek() <= times[i][0]) {
                queue.poll();
            }
            queue.offer(times[i][1]);
        }
        System.out.println(queue.size());
    }
}
