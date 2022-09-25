package stage.ten_recurtion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1004 {

    private static int[] arr, temp;
    private static int K;
    private static int result = -1;
    private static int count = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        temp = new int[N];
        mergeSort(arr, 0, arr.length-1);

        System.out.println(result);
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (count > K) return ;
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int part1 = start;
        int part2 = mid + 1;
        int index = 0;

        while(part1 <= mid && part2 <= end) {
            if(arr[part1] <= arr[part2]) {
                temp[index] = arr[part1];
                part1++;
            }
            else {
                temp[index] = arr[part2];
                part2++;
            }
            if(count == K) {
                result = temp[index];
            }
            index++;
        }
        while (part1 <= mid) {
            temp[index++] = arr[part1++];
        }
        while (part2 <= end) {
            temp[index++] = arr[part2++];
        }

        part1 = start;
        index = 0;
        while (part1 <= end) {
            count++;
            if(count == K) {
                result = temp[index];
                break;
            }
            arr[part1++] = temp[index++];
        }
    }
}
