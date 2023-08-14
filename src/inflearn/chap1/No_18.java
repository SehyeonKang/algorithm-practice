package inflearn.chap1;

import java.util.Scanner;

public class No_18 {
    public String solution(String str) {
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");

        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equals(tmp))
            answer = "YES";

        return answer;
    }

    public static void main(String[] args) {
        No_18 T = new No_18();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
