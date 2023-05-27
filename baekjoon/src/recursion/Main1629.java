package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		System.out.println(recursive(a, b, m));
	}

	public static long recursive(int a, int b, int m) {
		if (b == 1) return a % m;
		long num = recursive(a, b/2, m);
		num = num * num % m;

		if (b % 2 == 0) return num;
		return num * a % m;
	}
}
