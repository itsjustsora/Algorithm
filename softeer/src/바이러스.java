package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 바이러스 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");

		int k = Integer.parseInt(info[0]);
		int p = Integer.parseInt(info[1]);
		int n = Integer.parseInt(info[2]);

		for (int i = 0; i < n; i++) {
			k *= p;
		}

		System.out.println(k % 1000000007);
	}
}
