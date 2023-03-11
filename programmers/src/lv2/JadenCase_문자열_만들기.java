package lv2;

public class JadenCase_문자열_만들기 {
	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		String[] line = s.toLowerCase().split(" ");
		for (int i = 0; i < line.length; i++) {
			String str = line[i];
			if (str.length() == 0) {
				sb.append(" ");
				continue;
			}
			sb.append(str.substring(0,1).toUpperCase());
			sb.append(str.substring(1,str.length()));
			sb.append(" ");

		}
		if (!" ".equals(s.substring(s.length()-1, s.length()))) {
			sb.deleteCharAt(sb.lastIndexOf(" "));
		}
		return sb.toString();
	}
}
