package inflearn.chap5;

import java.util.Scanner;
import java.util.Stack;

public class No_5 {
    public int solution(String s) {
        int answer = 0;
        boolean laser = true;
        Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            if (x == '(') {
                stack.push(x);
                laser = true;
            }

            if (x == ')') {
                stack.pop();
                if (laser) {
                    answer += stack.size();
                    laser = false;
                } else {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        No_5 T = new No_5();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(T.solution(s));
    }
}
