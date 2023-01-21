package old.brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ppl = new int[9];
        int sum = 0;

        for (int i = 0; i < ppl.length; i++) {
          ppl[i] = Integer.parseInt(br.readLine());
          sum += ppl[i];
        }

        for(int i = 0; i < ppl.length - 1; i++) {
            for (int j = i+1; j < ppl.length; j++) {
                if (sum - (ppl[i] + ppl[j]) == 100) {
                    ppl[i] = 0;
                    ppl[j] = 0;

                    Arrays.sort(ppl);

                    for(int k = 2; k < ppl.length; k++) {
                        System.out.println(ppl[k]);
                    }
                    return;
                }
            }
        }


    }
}
