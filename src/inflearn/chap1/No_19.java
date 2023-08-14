package inflearn.chap1;

import java.util.Scanner;

public class No_19 {
    public int solution(String str) {
        int answer = 0;

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                answer = answer * 10 + c - 48;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        No_19 T = new No_19();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
