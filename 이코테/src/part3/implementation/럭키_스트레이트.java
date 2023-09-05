package src.part3.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 럭키_스트레이트 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 	String score = br.readLine();

	 	int len = score.length() / 2;
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += score.charAt(i) - '0';
		}

		 for (int i = len; i < score.length(); i++) {
			 sum -= score.charAt(i) - '0';
		 }

	  	 if (sum == 0) {
			 System.out.println("LUCKY");
		 } else {
			 System.out.println("READY");
		 }
	}
}
