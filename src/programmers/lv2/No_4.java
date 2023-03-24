package programmers.lv2;

public class No_4 {

    public static void main(String[] args) {
        String s = "(()(";
        boolean ans = solution(s);

        if (ans) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static boolean solution(String s) {
        boolean answer = true;
        int stack = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack++;
            } else {
                if (stack == 0) {
                    answer = false;
                    break;
                }

                stack--;
            }
        }

        if (stack != 0)
            answer = false;

        return answer;
    }
}
