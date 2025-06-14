package it_prep.data_structure;

import java.util.HashSet;
import java.util.Set;

class Main0301 {
    public Integer solution(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }

        int answer = 0;

        for (int x : set) {
            if (set.contains(x - 1)) continue;

            int cnt = 0;

            while (set.contains(x)) {
                cnt++;
                x++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        Main0301 T = new Main0301();
        System.out.println(T.solution(new int[] {8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[] {3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[] {-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[] {-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}