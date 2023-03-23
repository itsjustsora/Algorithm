package lv2;

import java.util.ArrayList;

public class 일차_뉴스_클러스터링 {
	public int solution(String str1, String str2) {
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		ArrayList<String> g = new ArrayList<>();
		ArrayList<String> h = new ArrayList<>();

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		for(int i = 0 ; i < str1.length() - 1 ; ++i){
			char first = str1.charAt(i);
			char second = str1.charAt(i + 1);

			if(first >= 'a' && first <= 'z' &&
				second >= 'a' && second <= 'z'){
				list1.add(first + "" + second);
			}
		}

		for(int i = 0 ; i < str2.length() - 1 ; ++i){
			char first = str2.charAt(i);
			char second = str2.charAt(i + 1);

			if(first >= 'a' && first <= 'z' &&
				second >= 'a' && second <= 'z'){
				list2.add(first + "" + second);
			}
		}

		for(String s : list1){
			if(list2.remove(s)){
				g.add(s);
			}
			h.add(s);
		}
		h.addAll(list2);

		double jakard = 0;

		if(h.size() == 0) {
			jakard = 1;
		} else {
			jakard = (double)g.size() / (double)h.size();
		}

		return (int)(jakard * 65536);
	}
}
