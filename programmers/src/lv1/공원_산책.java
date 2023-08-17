package lv1;

public class 공원_산책 {
	public int[] solution(String[] park, String[] routes) {
		int x = 0;
		int y = 0;

		int h = park.length;
		int w = park[0].length();

		for (int i = 0; i < h; i++) {
			String line = park[i];
			for (int j = 0; j < w; j++) {
				if (line.charAt(j) == 'S') {
					x = j;
					y = i;
				}
			}
		}

		for (String route : routes) {
			String[] split = route.split(" ");
			String dir = split[0];
			int len = Integer.parseInt(split[1]);

			int nx = x;
			int ny = y;

			for (int i = 0; i < len; i++) {
				if (dir.equals("N")) {
					ny--;
				} else if (dir.equals("E")) {
					nx++;
				} else if (dir.equals("S")) {
					ny++;
				} else if (dir.equals("W")) {
					nx--;
				}

				if (nx >= 0 && nx < w && ny >= 0 && ny < h) {
					if(park[ny].charAt(nx) == 'X') {
						break;
					}
					if (i == len - 1) {
						x = nx;
						y = ny;
					}
				}
			}

		}
		return new int[] {y, x};
	}
}
