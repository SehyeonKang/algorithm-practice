package programmers.lv2;

import java.util.StringTokenizer;

/**
 * JadenCase 문자열 만들기
 */
public class No_2 {

    public static void main(String[] args) {
        String ans = solution("3people unFollowed  me");
        System.out.println(ans);
    }

    static private String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            String str = st.nextToken();

            if (str.startsWith(" ")) {
                sb.append(str);
                continue;
            }

            if (str.charAt(0) < 'a') {
                sb.append(str.charAt(0));
            } else {
                sb.append((char) (str.charAt(0) - 32));
            }

            sb.append(str.substring(1).toLowerCase());
        }

        return sb.toString();
    }
}
