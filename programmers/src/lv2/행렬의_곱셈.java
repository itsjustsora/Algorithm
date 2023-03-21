package lv2;

public class 행렬의_곱셈 {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];

		// arr1의 행의 수
		for(int i = 0; i < answer.length; i++){
			// arr1의 열의 수 = arr2의 행의 수
			for(int j = 0; j < answer[i].length; j++){
				// arr2의 행의 수
				for(int k = 0; k < arr1[0].length; k++){
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		return answer;
	}
}
