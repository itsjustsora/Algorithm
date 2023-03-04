package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main0607 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Point> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			arr.add(new Point(first, second));
		}

		// 재정의한 compareTo를 기준으로 정렬
		Collections.sort(arr);

		for(Point o : arr) {
			System.out.println(o.x + " " + o.y);
		}

	}
}

class Point implements Comparable<Point> {
	public int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// 오름차순이므로 this.y - o.y
	@Override
	public int compareTo(Point o) {
		if (this.x == o.x) {
			return this.y - o.y;
		}
		return this.x - o.x;
	}
}
