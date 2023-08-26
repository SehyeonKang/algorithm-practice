package inflearn.chap5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No_6 {
    public int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            for (int i = 0; i < k; i++) {
                int num = queue.poll();

                if (i < k - 1) {
                    queue.offer(num);
                }
            }
        }
        answer = queue.poll();
        return answer;
    }

    public static void main(String[] args) {
        No_6 T = new No_6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(T.solution(n, k));
    }
}
