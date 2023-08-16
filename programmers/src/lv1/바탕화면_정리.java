package lv1;

public class 바탕화면_정리 {
	public int[] solution(String[] wallpaper) {
		int lux = Integer.MAX_VALUE;
		int luy = Integer.MAX_VALUE;
		int rux = Integer.MIN_VALUE;
		int ruy = Integer.MIN_VALUE;

		for (int i = 0; i < wallpaper.length; i++) {
			String paper = wallpaper[i];
			for (int j = 0; j < paper.length(); j++) {
				if (paper.charAt(j) == '#') {
					lux = Math.min(lux, i);
					luy = Math.min(luy, j);
					rux = Math.max(rux, i + 1);
					ruy = Math.max(ruy, j + 1);
				}
			}
		}
		return new int[] {lux, luy, rux, ruy};
	}
}
