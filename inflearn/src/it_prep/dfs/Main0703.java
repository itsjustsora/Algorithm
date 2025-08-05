package it_prep.dfs;

import java.util.ArrayList;

/**
 * n명의 바둑 기사, 각각 흰 돌과 검은 돌로 출전하는 선수 n/2명
 * 흰 돌팀과 검은 돌팀의 능력차가 최소가 되어야 할 때 그 최소값을 반환하는 프로그램
 */
class Main0703 {

    int answer = 1000000000;
    int n;
    int[] ch;

    public Integer solution(int[][] cans){
       n =  cans.length;
       ch = new int[n];
       dfs(0, 0, cans);
       return answer;
    }

    private void dfs(int level, int start,  int[][] cans) {
        if (level == n/2) {
            ArrayList<Integer> white = new ArrayList<>();
            ArrayList<Integer> black = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (ch[i] == 1) white.add(i);
                else black.add(i);
            }

            int whiteTotal = 0,  blackTotal = 0;
            for (int i = 0; i < level; i++) {
               whiteTotal += cans[white.get(i)][0];
               blackTotal += cans[black.get(i)][1];
            }
            answer = Math.min(answer, Math.abs(whiteTotal -  blackTotal));
        } else {
            for (int i = start; i < n; i++) {
                ch[i] = 1;
                dfs(level + 1, i + 1, cans);
                ch[i] = 0;
            }
        }
    }

    public static void main(String[] args){
        Main0703 T = new Main0703();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
    }
}