package inflearn.chap1;

import java.util.Scanner;

public class No_17 {
    public String solution(String str) {
        String answer = "YES";
        int len = str.length();
        str = str.toUpperCase();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1))
                return "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        No_17 T = new No_17();
        Scanner sc = new Scanner(System.in);
        String str= sc.next();
        System.out.println(T.solution(str));
    }
}
