package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main0901 {

	// 현재에서 제일 좋은 걸 선택해 나가는 것.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Person> arr = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			arr.add(new Person(h, w));
		}
		System.out.println(solution(arr, N));
	}

	private static int solution(ArrayList<Person> arr, int n) {
		int cnt = 0;
		Collections.sort(arr);
		int max = Integer.MIN_VALUE;

		for(Person obj : arr) {
			if (obj.weight > max) {
				max = obj.weight;
				cnt++;
			}
		}

		return cnt;
	}
}

class Person implements Comparable<Person> {
	int height;
	int weight;

	public Person(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}

	@Override
	public int compareTo(Person o) {
		return o.height - this.height;
	}
}