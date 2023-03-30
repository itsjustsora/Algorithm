package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main0403 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		ArrayList<Integer> list = solution(N, K, arr);

		for (int i : list) {
			System.out.print(i + " ");
		}
	}

	private static ArrayList<Integer> solution(int n, int k, int[] arr) {

		ArrayList<Integer> answer = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		answer.add(map.size());

		for (int rt = k; rt < n; rt++) {
			map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
			map.put(arr[rt-k], map.get(arr[rt-k]) - 1);

			if (map.get(arr[rt-k]) == 0) {
				map.remove(arr[rt-k]);
			}
			answer.add(map.size());
		}
		return answer;
	}
}
