package inflearn.chap5;

import java.util.*;

public class No_8 {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int count = 1;
        int check = m;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            pq.offer(arr[i]);
            q.offer(arr[i]);
        }

        int tmp = 0;
        while (true) {
            if (pq.peek() == q.peek()) {
                if (check == 0)
                    break;

                pq.poll();
                q.poll();
                check--;
                count++;
            } else {
                int num = q.poll();
                q.offer(num);

                if (check == 0) {
                    check = q.size() - 1;
                } else
                    check--;
            }
        }

        answer = count;
        return answer;
    }

    public static void main(String[] args) {
        No_8 T = new No_8();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, m ,arr));
    }
}
