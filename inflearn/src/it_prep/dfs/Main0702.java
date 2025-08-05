package it_prep.dfs;

import java.util.Stack;

/**
 * 총 인원수 7명, 서로 싫어하는 학생끼리 이웃하지 않게 줄을 세우는 모든 방법의 수
 *
 * 1. 문제 분류 : 순열 문제 -> 제약 조건이(이웃) 있으므로 필터링 필요
 * 2. 알고리즘 선택 : 모든 경우를 탐색하되 조건 위반시 중단 -> 백트래킹(DFS)
 */
class Main0702 {

    int[][] relation;
    int[] ch;
    Stack<Integer> pm; // 현재 줄 서 있는 학생 순서
    int answer = 0;

    public Integer solution(int[][] students){
        relation =  new int[8][8];
        ch =  new int[8];
        pm = new Stack<>();

        // 양방향 관계
        for (int[] x : students) {
            relation[x[0]][x[1]] = 1;
            relation[x[1]][x[0]] = 1;
        }

        dfs(0);

        return answer;
    }

    private void dfs(int L) {
        if (L == 7) answer++;
        else {
            for (int i = 1; i < 8; i++) {
                // 방금 세운 학생과 i가 싫어하는 관계면 건너뜀
                if (!pm.empty() && relation[pm.peek()][i] == 1) continue;

                // 아직 줄에 서지 않은 학생이면
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm.push(i);
                    dfs(L + 1);
                    ch[i] = 0;
                    pm.pop();
                }
            }
        }
    }

    public static void main(String[] args){
        Main0702 T = new Main0702();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
    }
}