package lv2;

public class 일차_캐시 {
	public int solution(int cacheSize, String[] cities) {
		String[] cache = new String[cacheSize];
		int time = 0;

		if (cacheSize == 0) return cities.length * 5;

		for (String str : cities) {
			int pos = -1;
			for (int i = 0; i < cacheSize; i++) {
				if (cache[i] != null && cache[i].equalsIgnoreCase(str)) {
					pos = i;
				}
			}
			if (pos == -1) {
				time += 5;
				for (int i = cacheSize - 1; i >= 1; i--) {
					cache[i] = cache[i - 1];
				}
			} else {
				time += 1;
				for (int i = pos; i >= 1; i--) {
					cache[i] = cache[i - 1];
				}
			}
			cache[0] = str;
		}

		return time;
	}
}
