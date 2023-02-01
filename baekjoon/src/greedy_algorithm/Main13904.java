package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] assignments = new Node[N];
        for (int i = 0; i < N; i++) {
            String[] lines = br.readLine().split(" ");
            assignments[i] = new Node(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]));
        }

        Arrays.sort(assignments, ((o1, o2) -> {
            return o2.day - o1.day;
        }));

        PriorityQueue<Node> queue = new PriorityQueue<>();
        int lastDay = assignments[0].day;
        int idx = 0;
        int result = 0;
        for (int i = lastDay; 0 < i; i--) {
            while (idx < N && i <= assignments[idx].day) {
                queue.offer(assignments[idx++]);
            }

            if(!queue.isEmpty()) result += queue.poll().score;
        }
        System.out.println(result);
    }

    public static class Node implements Comparable<Node> {
        int day;
        int score;

        public Node(int day, int score) {
            this.day = day;
            this.score = score;
        }

        @Override
        public int compareTo(Node o) {
            return o.score - this.score;
        }
    }
}
