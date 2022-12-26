package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        float size = (float) n;
        int result = 0;
        Deque<Integer> deque = new LinkedList<>();


        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            int cnt = 0;

            for (Integer num : deque) {
                if (num == x) {
                    break;
                } else
                    cnt++;
            }

            if (cnt == 0) {
                deque.poll();
                size--;
                continue;
            } else if (cnt < size / 2) {
                for (int j = 0; j < cnt; j++) {
                    deque.offer(deque.peek());
                    deque.poll();
                }
                result += cnt;
            } else {
                for (int j = 0; j < size - cnt; j++) {
                    deque.offerFirst(deque.peekLast());
                    deque.pollLast();
                }
                result += size - cnt;
            }

            deque.poll();
            size--;
        }

        System.out.println(result);
    }
}
