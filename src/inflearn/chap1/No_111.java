package inflearn.chap1;

import java.util.Scanner;

public class No_111 {
    public String solution(String str) {
        String answer = "";
        int tmp = 1;

        answer += str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                tmp++;
            } else {
                if (tmp == 1) {
                    answer += str.charAt(i);
                } else {
                    answer += Integer.toString(tmp) + str.charAt(i);
                    tmp = 1;
                }
            }
        }

        if (tmp > 1)
            answer += Integer.toString(tmp);

        return answer;
    }

    public static void main(String[] args) {
        No_111 T = new No_111();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
