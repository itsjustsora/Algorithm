package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팔단_변속기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numbers = br.readLine();

		String asc = "1 2 3 4 5 6 7 8";
		String des = "8 7 6 5 4 3 2 1";


		if (numbers.equals(asc)) {
			System.out.println("ascending");
		} else if (numbers.equals(des)) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
}
