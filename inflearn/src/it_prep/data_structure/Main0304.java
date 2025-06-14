package it_prep.data_structure;

import java.util.LinkedList;
import java.util.Queue;

class Main0304 {
    public int solution(int[] laser, String[] enter){
        int answer = 0;
        int n = enter.length;
        int[][] inList = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] split = enter[i].split(" ");
            int min = toMinutes(split[0]);
            int laserNum = Integer.parseInt(split[1]);

            inList[i][0] = min;
            inList[i][1] = laserNum;
        }

        Queue<Integer> queue = new LinkedList<>(); // 대기실
        queue.offer(inList[0][1]); // 레이저 번호
        int finishTime = inList[0][0]; // 첫 고객(0)이 도착한 시간
        int pos = 1; // 두 번째 고객의 데이터 접근

        for (int t = finishTime; t <= 1200; t++) {
            if (pos < n && t == inList[pos][0]) {
                if (queue.isEmpty() && t > finishTime) {
                    finishTime = t;
                }
                queue.offer(inList[pos][1]);
                pos++;
            }
            if (t == finishTime && !queue.isEmpty()) {
                int idx = queue.poll();
                finishTime += laser[idx];
            }
            answer = Math.max(answer, queue.size());
        }
        return answer;
    }

    private int toMinutes(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;
    }


    public static void main(String[] args){
        Main0304 T = new Main0304();
        System.out.println(T.solution(
            new int[] {30, 20, 25, 15},
            new String[] {"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}
        ));
    }
}