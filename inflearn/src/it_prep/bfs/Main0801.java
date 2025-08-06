package it_prep.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 집으로 이동
 * 현수가 놀이터에서 집으로 이동해야 할 때 최소 점프 횟수 반환
 */
class Main0801 {

    public Integer solution(int[] pool, int a, int b, int home){
        int[][] ch = new int[10001][2];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0}); // 위치 0, 이전 점프는 앞(0)
        ch[0][0] = 1;
        int L = 0;
        int[] dis = {a, -b}; // 뒤 점프는 음수로 설정

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] info = q.poll(); // 해당 레벨의 값 꺼내기
                int x = info[0];
                int prevDir = info[1]; // 0: 앞, 1: 뒤

                for (int i = 0; i < 2; i++) {
                    if (prevDir == 1 && i == 1) continue; // 뒤→뒤 점프 불가

                    int next = x + dis[i];
                    int dir = i;

                    if (next < 0 || next >= 10000) continue;
                    if (contains(pool, next)) continue;
                    if (ch[next][dir] == 1) continue;
                    if (next == home) return L + 1;

                    ch[next][dir] = 1;
                    q.offer(new int[]{next, dir});
                }
            }
            L++;
        }

        return -1;
    }

    private boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }

    public static void main(String[] args){
        Main0801 T = new Main0801();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
    }
}