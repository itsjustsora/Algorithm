package it_prep.hashing;

import java.util.HashMap;
import java.util.Map;

class Main0203 {
    public Integer solution(int[] arr, int m){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : arr) {
            sum += num;

            // (누적합 - m)이 이전에 있었다면
            if (map.containsKey(sum - m)) {
                count += map.get(sum - m);
            }

            // 현재 누적합 기록
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args){
        Main0203 T = new Main0203();
        System.out.println(T.solution(new int[] {2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[] {1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[] {1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[] {-1, 0, 1}, 0));
        System.out.println(T.solution(new int[] {-1, -1, -1, 1}, 0));
    }
}