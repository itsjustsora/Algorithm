package it_prep.greedy;

import java.util.Arrays;

class Main0602 {
    public Integer solution(int[] nums){
        int m = 5;
        int answer = 0;

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] + nums[right] <= m) {
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
        Main0602 T = new Main0602();
        System.out.println(T.solution(new int[] {2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[] {2, 3, 4, 5}));
        System.out.println(T.solution(new int[] {3, 3, 3, 3, 3}));
    }
}