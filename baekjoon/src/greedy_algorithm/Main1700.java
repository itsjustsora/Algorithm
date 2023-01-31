package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = br.readLine().split(" ");

        int N = Integer.parseInt(lines[0]);
        int K = Integer.parseInt(lines[1]);

        int[] orders = new int[K];
        String[] strings = br.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            orders[i] = Integer.parseInt(strings[i]);
        }

        // 멀티탭에 꽂힐 전기용품
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        for (int i = 0; i < K; i++) {
            if (!set.contains(orders[i])) {
                if (N <= set.size()) { // 멀티탭에 전기용품이 전부 사용 중일 때
                    List<Integer> list = new ArrayList<>();
                    Set<Integer> remain = new HashSet<>(set);

                    for (int j = i; j < K; j++) {
                        if (set.contains(orders[j]) && !list.contains(orders[j])) {
                            list.add(orders[j]);
                            remain.remove(orders[j]);
                        }
                    }

                    if (list.size() == N) {
                        set.remove(list.get(list.size() - 1));
                    } else {
                        List<Integer> temp = new ArrayList<>(remain);
                        set.remove(temp.get(0));
                    }
                    answer++;
                }
                // 멀티탭이 전부 사용 중이지 않을 때 전기용품 추가
                set.add(orders[i]);
            }
        }

        System.out.println(answer);

    }
}
