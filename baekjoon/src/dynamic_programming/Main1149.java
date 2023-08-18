package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1149 {

	final static int RED = 0;
	final static int GREEN = 1;
	final static int BLUE = 2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] cost = new int[n][3];

		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split(" ");

			cost[i][RED] = Integer.parseInt(split[0]);
			cost[i][GREEN] = Integer.parseInt(split[1]);
			cost[i][BLUE] = Integer.parseInt(split[2]);
		}

		for (int i = 1; i < n; i++) {
			cost[i][RED] += Math.min(cost[i-1][GREEN], cost[i-1][BLUE]);
			cost[i][GREEN] += Math.min(cost[i-1][RED], cost[i-1][BLUE]);
			cost[i][BLUE] += Math.min(cost[i-1][GREEN], cost[i-1][RED]);
		}

		System.out.println(Math.min(Math.min(cost[n-1][RED], cost[n-1][GREEN]), cost[n-1][BLUE]));
	}
}
