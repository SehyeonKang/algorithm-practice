package inflearn.chap5;

import java.util.Scanner;
import java.util.Stack;

public class No_2 {
    public String solution(String s) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            stack.push(x);

            if (x == ')') {
                while (true) {
                    char c = stack.pop();
                    if (c == '(')
                        break;
                }
            }
        }

        for (char x : stack) {
            answer += x;
        }
        return answer;
    }

    public static void main(String[] args) {
        No_2 T = new No_2();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(T.solution(s));
    }
}
