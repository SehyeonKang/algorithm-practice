package inflearn.chap1;

import java.util.Scanner;

public class No_13 {
    public String solution(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        String[] str = s.split(" ");

        for (String x : str) {
            int len = x.length();
            if (len > max) {
                max = len;
                answer = x;
            }
        }

        return answer;
    }

    public String solution2(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int pos;

        while ((pos = s.indexOf(" ")) != -1) {
            String tmp = s.substring(0, pos);
            int len = tmp.length();
            if (len > max) {
                max = len;
                answer = tmp;
            }
            s = s.substring(pos + 1);
        }

        if (s.length() > max)
            answer = s;

        return answer;
    }

    public static void main(String[] args) {
        No_13 T = new No_13();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(T.solution(s));
    }
}
