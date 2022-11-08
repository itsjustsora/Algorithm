package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 멀티탭 구멍의 개수
        int K = Integer.parseInt(st.nextToken()); // 전기 용품의 총 사용횟수

        int[] orders = new int[K];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            orders[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] use = new boolean[101];
        int put = 0;
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            int temp = orders[i];

            if (!use[temp]) { // 콘센트가 꽂혀있지 않은 경우
                if (put < N) { // 콘센트를 꽂을 공간이 있는 경우
                    use[temp] = true;
                    put++;
                } else { // 콘센트를 꽂을 공간이 없는 경우
                    ArrayList<Integer> arrList = new ArrayList<>();
                    for (int j = i; j < K; j++) { // 현재 꽂혀있는 전기제품이 나중에도 사용되는지 확인
                        if (use[orders[j]] && !arrList.contains(orders[j])) {
                            arrList.add(orders[j]);
                        }
                    }

                    if (arrList.size() != N) { // 나중에도 사용되는 전기제품의 수가 구멍의 개수보다 작을 경우
                       for (int j = 0; j < use.length; j++) {
                           if (use[j] && !arrList.contains(j)) {
                               use[j] = false;
                               break;
                           }
                       }
                    } else { // 현재 꽂혀 있는 모든 제품이 나중에도 사용될 경우
                        int remove = arrList.get(arrList.size() - 1); // 가장 마지막에 사용될 제품을 제거
                        use[remove] = false;
                    }

                    use[temp] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
}
