package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sensorCnt = Integer.parseInt(br.readLine());
        int baseCnt = Integer.parseInt(br.readLine());

        int[] sensors = new int[sensorCnt];
        String[] lines = br.readLine().split(" ");
        for (int i = 0; i < sensorCnt; i++) {
            sensors[i] = Integer.parseInt(lines[i]);
        }

        Arrays.sort(sensors);

        Integer[] diff = new Integer[sensorCnt - 1];
        for (int i = 0; i < sensorCnt - 1; i++) {
            diff[i] = sensors[i+1] - sensors[i];
        }

        Arrays.sort(diff, Comparator.reverseOrder());
        int sum = 0;
        // 가장 간격이 높은 센서 위치를 분리시켜 최소합을 구한다.
        for (int i = baseCnt - 1; i < sensorCnt - 1; i++) {
            sum += diff[i];
        }
        System.out.println(sum);
    }
}
