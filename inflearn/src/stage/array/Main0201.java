package stage.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main0201 {

    public static ArrayList<Integer> solution(int num, int[] arr) {
//        String[] arr = str.split(" ");
//        String answer = arr[0] + " ";
//
//        for (int i = 0; i < num-1; i++) {
//            if (Integer.parseInt(arr[i]) < Integer.parseInt(arr[i+1])) {
//                answer += arr[i+1] + " ";
//            }
//        }

        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        for(int i = 1; i < num; i++) {
            if(arr[i] > arr[i-1]) answer.add(arr[i]);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        for(int x : solution(num, arr)) {
            System.out.println(x + " ");
        }

    }
}
