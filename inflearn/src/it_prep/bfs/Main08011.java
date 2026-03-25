package it_prep.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 집으로 이동
 * 현수가 놀이터에서 집으로 이동해야 할 때 최소 점프 횟수 반환
 */
class Main08011 {

    public Integer solution(int[] pool, int a, int b, int home){
        Set<Integer> poolSet = new HashSet<>();
        for (int p : pool) {
            poolSet.add(p);
        }

        boolean[][] visited = new boolean[10001][2];
        int[][] dist = new int[10001][2];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        dist[0][0] = 0;

        int[] dis = {a, -b};

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int prevDir = now[1];

            for (int i = 0; i < 2; i++) {
                if (prevDir == 1 && i == 1) continue;

                int next = x + dis[i];
                int dir = i;

                if (next < 0 || next > 10000) continue;

                if (poolSet.contains(next)) continue;

                if (visited[next][dir]) continue;

                visited[next][dir] = true;
                dist[next][dir] = dist[x][prevDir] + 1;

                if (next == home) {
                    return dist[next][dir];
                }

                queue.offer(new int[]{next, dir});
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Main08011 T = new Main08011();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
    }
}