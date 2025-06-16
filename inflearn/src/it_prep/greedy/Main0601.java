package it_prep.greedy;

import java.util.Arrays;

class Main0601 {
    public Integer solution(int[] arr, int m){
        int answer = 0;
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            if (arr[left] + arr[right] <= m) {
                answer++;
                left++;
                right--;
            } else {
                answer++;
                right--;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main0601 T = new Main0601();
        System.out.println(T.solution(new int[] {90, 50, 70, 100, 60}, 140));
    }
}