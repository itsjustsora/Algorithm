package brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1182 {

    /*
    * 백트래킹 알고리즘
    * 현재 상태에서 가능한 모든 후보군(선택지)을 따라 들어가며 탐색하는 알고리즘
    * 원소가 n일 때 부분집합의 갯수는 2ⁿ이다.
    * 각 원소를 포함하지 않거나 포함하거나 하여 모든 선택지를 만든 형태를 상태 공간 트리라고 한다.
    * */

    public static int N, S;
    public static int result = 0;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = br.readLine().split(" ");

        N = Integer.parseInt(lines[0]);
        S = Integer.parseInt(lines[1]);

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);

        // 부분집합에서 원소의 합이 0일 경우인 공집합을 빼준다(-1).
        System.out.println(S == 0 ? result - 1 : result);

    }

    public static void DFS(int i, int sum) {
        if (i == N) {
            if (sum == S) result++;
            return;
        }
        // i번째 수를 더할지 말지 정하고 i+1번째 수를 정하러 한 단계 더 들어간다.
        DFS(i + 1, sum + arr[i]);
        DFS(i + 1, sum);
    }
}
