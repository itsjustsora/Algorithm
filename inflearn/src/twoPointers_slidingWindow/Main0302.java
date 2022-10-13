package twoPointers_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main0302 {

    public static ArrayList<Integer> solution(int[] a1, int[] a2) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(a1);
        Arrays.sort(a2);
        int p1 = 0, p2 = 0;
        int n = a1.length;
        int m = a2.length;

        while(p1 < n && p2 < m) {
            if (a1[p1] == a2[p2]) {
                list.add(a1[p1++]);
                p2++;
            }
            else if(a1[p1] < a2[p2]) p1++;
            else p2++;
        }
        return list;
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
