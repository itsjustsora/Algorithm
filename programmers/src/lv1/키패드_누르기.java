package lv1;

public class 키패드_누르기 {
	Position left;
	Position right;
	Position numPos;

	public String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();
		left = new Position(3, 0);
		right = new Position(3, 2);

		for (int num : numbers) {
			numPos = new Position((num - 1) / 3, (num - 1) % 3);

			if (num == 0) numPos = new Position(3, 1);
			String finger = numPos.getFinger(hand);

			sb.append(finger);
			if (finger.equals("L")) left = numPos;
			else right = numPos;
		}
		return sb.toString();
	}

	class Position {
		int row;
		int col;

		Position(int row, int col) {
			this.row = row;
			this.col = col;
		}

		public String getFinger(String hand) {
			String finger = hand.equals("left") ? "L" : "R";

			if (this.col == 0) {
				finger = "L";
			} else if (this.col == 2) {
				finger = "R";
			} else {
				int leftDist = left.getDistance(this);
				int rightDist = right.getDistance(this);

				if (leftDist < rightDist) {
					finger = "L";
				} else if (rightDist < leftDist) {
					finger = "R";
				}
			}
			return finger;
		}

		public int getDistance(Position p) {
			return Math.abs(this.col - p.col) + Math.abs(this.row - p.row);
		}
	}
}
