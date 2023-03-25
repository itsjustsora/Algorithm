package lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 삼차_압축 {
	public Integer[] solution(String msg) {
		ArrayList<Integer> answer = new ArrayList<>();
		String c="";
		String w="";
		String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Map<String, Integer> map = new HashMap();

		for(int i = 0; i < 26; i++){
			map.put(alphabet.substring(i, i + 1), i + 1);
		}

		while (true){
			if(map.containsKey(msg)){
				answer.add(map.get(msg));
				break;
			}

			for(int i = 0; i < msg.length(); i++){
				c = msg.substring(0, i + 1);
				if(!map.containsKey(c)){
					w = msg.substring(0, i);
					answer.add(map.get(w));
					msg = msg.substring(i);
					map.put(c, map.size() + 1);
					break;
				}
			}
		}

		Integer[] ans = answer.toArray(new Integer[answer.size()]);
		return ans;
	}
}
