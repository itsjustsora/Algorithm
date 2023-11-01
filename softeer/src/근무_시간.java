package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 근무_시간 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int hour = 0;
		int min = 0;

		for (int i = 0; i < 5; i++) {
			String[] timeline = br.readLine().split(" ");

			int preHour = Integer.parseInt(timeline[0].substring(0,2));
			int preMin = Integer.parseInt(timeline[0].substring(3));

			int nextHour = Integer.parseInt(timeline[1].substring(0,2));
			int nextMin = Integer.parseInt(timeline[1].substring(2));

			hour += (nextHour - preHour);
			min += (nextMin - preMin);

			if (min >= 60) {
				hour += min / 60;
				min = min % 60;
			}
		}

		System.out.println((hour * 60) + min);
	}
}
