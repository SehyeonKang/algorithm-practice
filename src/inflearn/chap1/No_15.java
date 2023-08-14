package inflearn.chap1;

import java.util.Scanner;

public class No_15 {
    public String solution(String str) {
        String answer = "";
        char[] arr = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;

        while (lt < rt) {
            if (!Character.isAlphabetic(arr[lt])) {
                lt++;
                continue;
            } else if (!Character.isAlphabetic(arr[rt])) {
                rt--;
                continue;
            }

            char tmp = arr[lt];
            arr[lt] = arr[rt];
            arr[rt] = tmp;
            lt++;
            rt--;
        }

        answer = String.valueOf(arr);
        return answer;
    }

    public static void main(String[] args) {
        No_15 T = new No_15();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
