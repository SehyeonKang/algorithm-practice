package inflearn.chap5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No_7 {
    public String solution(String s1, String s2) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();
        for (char x : s1.toCharArray()) {
            queue.offer(x);
        }

        for (char x : s2.toCharArray()) {
            if (queue.peek() == x) {
                queue.poll();

                if (queue.isEmpty())
                    return answer;
            }

        }

        if (!queue.isEmpty())
            return "NO";

        return answer;
    }

    public static void main(String[] args) {
        No_7 T = new No_7();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(T.solution(s1, s2));
    }
}
