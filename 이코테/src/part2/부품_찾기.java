package src.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부품_찾기 {

	// 시간복잡도 : O(n log n) + O(m log n)
	// 공간복잡도 : O(n + m)
	// 합해야 할 문자열의 개수가 적은 경우 -> StringBuilder 보다는 그냥 String +=
	// 입력받는 문자열을 split 할 때 개수가 적은 경우 -> StringTokenizer 보다는 그냥 String[] = ...split(" ");

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			int start = 0, end = n-1;
			int tmp = Integer.parseInt(st.nextToken());
			while (start <= end) {
				int mid = (start + end) / 2;

				if (arr[mid] == tmp) {
					sb.append("yes");
					break;
				} else if (arr[mid] > tmp) {
					end = mid - 1;
				} else if (arr[mid] < tmp) {
					start = mid + 1;
				}

				if (start > end) {
					sb.append("no");
				}
			}
			sb.append(" ");
		}
		System.out.println(sb);
	}
}
