package it_prep.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Main0202 {
    public int[] solution(String s){
        Map<Character, Integer> map = new HashMap<>();
        int[] answer = new int[5];
        int max = 0;

        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);

            if (max < map.get(x)) {
                max = map.get(x);
            }
        }

        for (int i = 0; i < 5; i++) {
            char x = (char)(i + 97);
            int cnt = map.getOrDefault(x, 0);
            answer[i] = max - cnt;
        }

        return answer;
    }

    public static void main(String[] args){
        Main0202 T = new Main0202();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}