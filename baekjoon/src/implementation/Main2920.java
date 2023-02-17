package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] nums = new int[8];
		for (int i = 0; i < 8; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		String answer = "";
		for (int i = 0; i < 7; i++) {
			if (nums[i+1] == nums[i] + 1) {
				answer = "ascending";
			}
			else if (nums[i+1] == nums[i] - 1) {
				answer = "descending";
			} else {
				answer = "mixed";
				break;
			}
		}
		System.out.println(answer);
	}
}
