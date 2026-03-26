package it_prep.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 송아지 잡기
 * 현수가 송아지를 잡는 가장 빠른 시간 반
 */
class Main0802 {

    public Integer solution(int s, int e){
        Queue<Integer> queue = new LinkedList<>();

        // 방문 체크
        int[][] ch = new int[2][200001];

        ch[0][s] = 1;
        queue.offer(s);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int i = 0; i < size; i++) {
                int now = queue.poll();

                int[] next = {now + 1, now - 1, now * 2};

                for (int nx : next) {
                    if (nx < 0 || nx > 200000 || (ch[level % 2][nx] != 0)) continue;

                    ch[level % 2][nx] = 1;
                    queue.offer(nx);
                }
            }
            e = e + level;
            if (e > 200000) return -1;
            if (ch[level % 2][e] == 1) return level;
        }
        return -1;
    }

    public static void main(String[] args){
        Main0802 T = new Main0802();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}