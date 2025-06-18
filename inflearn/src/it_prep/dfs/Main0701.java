package it_prep.dfs;

import java.util.ArrayList;

class Main0701 {

    private int answer, target, m;
    private ArrayList<Integer> nums;
    private int[] ch;
    private boolean flag;

    public Integer solution(int n){
        answer = 0;
        flag = false;
        nums = new ArrayList<>();
        target = n;

        int tmp = n;
        while (tmp > 0) {
            int t = tmp % 10;
            nums.add(t);
            tmp = tmp / 10;
        }

        nums.sort((a, b) -> a - b);

        m = nums.size();
        ch = new int[m];
        dfs(0, 0);

        if (!flag) return -1;

        return answer;
    }

    private void dfs(int level, int number) {
        if (flag) return;

        if (level == m) {
            if (number > target) {
                answer = number;
                flag = true;
            }
        } else {
            for (int i = 0; i < m; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    dfs(level + 1, number * 10 + nums.get(i));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        Main0701 T = new Main0701();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}