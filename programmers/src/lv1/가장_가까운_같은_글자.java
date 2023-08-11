package lv1;

import java.util.HashMap;
import java.util.List;

public class 가장_가까운_같은_글자 {
	public int[] solution(String s) {
		int[] answer = new int[s.length()];
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i=0; i<s.length();i++){
			char ch = s.charAt(i);
			answer[i] = i-map.getOrDefault(ch,i+1);
			map.put(ch,i);
		}
		return answer;
	}
}
