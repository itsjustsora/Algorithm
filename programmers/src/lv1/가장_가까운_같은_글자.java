package lv1;

import java.util.ArrayList;
import java.util.List;

public class 가장_가까운_같은_글자 {
	public List solution(String s) {
		List<Integer> list = new ArrayList<>();
		list.add(-1);

		for (int i = 1; i < s.length(); i++) {
			char ch = s.charAt(i);
			int count = 0;
			for (int j = 0; j < i; j++) {
				if (s.charAt(j) == ch) {
					count = i - j;
				}
			}
			if (count == 0) list.add(-1);
			else list.add(count);
		}
		return list;
	}
}
