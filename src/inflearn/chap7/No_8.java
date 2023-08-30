package inflearn.chap7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No_8 {
    public int solution(int s, int e) {
        int answer = 0;
        int L = 0;
        boolean[] check = new boolean[10001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        check[s] = true;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int pos = queue.poll();

                if (pos == e) {
                    answer = L;
                    break;
                }

                if (!check[pos - 1] && !queue.contains(pos - 1) && pos - 1 > 0) {
                    queue.offer(pos - 1);
                    check[pos - 1] = true;
                }
                if (!check[pos + 1] && !queue.contains(pos + 1) && pos + 1 <= 10000) {
                    queue.offer(pos + 1);
                    check[pos + 1] = true;
                }
                if (!check[pos + 5] && !queue.contains(pos + 5) && pos + 5 <= 10000) {
                    queue.offer(pos + 5);
                    check[pos + 5] = true;
                }
            }
            L++;
            if (answer > 0)
                break;
        }

        return answer;
    }

    public static void main(String[] args) {
        No_8 T = new No_8();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(T.solution(s, e));
    }
}
