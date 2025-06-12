package it_prep.hashing;

import java.util.*;
class Main0201 {
    public Integer solution(String s){
        Map<Character, Integer> map = new HashMap<>();
        int answer = -1;

        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                answer = i + 1;

                break;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        it_prep.hashing.Main0201 T = new it_prep.hashing.Main0201();
        System.out.println(T.solution("statistics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}