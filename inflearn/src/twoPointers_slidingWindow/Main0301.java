package twoPointers_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main0301 {

    public static ArrayList<Integer> solution(int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        int n = arr1.length;
        int m = arr2.length;

        while (p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) answer.add(arr1[p1++]);
            else answer.add(arr2[p2++]);
        }
        while (p1 < n) answer.add(arr1[p1++]);
        while (p2 < m) answer.add(arr2[p2++]);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr1 = new int[Integer.parseInt(br.readLine())];
        String[] str1 = br.readLine().split(" ");
        for(int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(str1[i]);
        }

        int[] arr2 = new int[Integer.parseInt(br.readLine())];
        String[] str2 = br.readLine().split(" ");
        for(int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(str2[i]);
        }

        for(int i : solution(arr1, arr2)) {
            System.out.print(i + " ");
        }

    }
}
