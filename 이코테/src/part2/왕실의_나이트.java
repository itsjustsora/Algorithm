package src.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 왕실의_나이트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();

		int row = line[1] - '0';
		int column = line[0] - 'a' + 1;

		int count = 0;

		int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

		for (int i = 0; i < 8; i ++) {
			int nx = column + dx[i];
			int ny = row + dy[i];

			if (nx < 1 || ny < 1 || nx > 8 || ny > 8) continue;

			count++;
		}

		System.out.println(count);
	}
}
