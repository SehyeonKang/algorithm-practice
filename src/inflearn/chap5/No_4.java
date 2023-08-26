package inflearn.chap5;

import java.util.Scanner;
import java.util.Stack;

public class No_4 {
    public int solution(String s) {
        int answer;
        Stack<Integer> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            if (Character.isDigit(x)) {
                stack.push(x - 48);
            } else {
                int b = stack.pop();
                int a = stack.pop();
                if (x == '+') {
                    stack.push(a + b);
                } else if (x == '-') {
                    stack.push(a - b);
                } else if (x == '*') {
                    stack.push(a * b);
                } else {
                    stack.push(a / b);
                }
            }
        }

        answer = stack.pop();
        return answer;
    }

    public static void main(String[] args) {
        No_4 T = new No_4();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(T.solution(s));
    }
}
