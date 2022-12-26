package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<Integer> deque = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            Integer x;

            if (s.equals("push_front")) {
                x = Integer.parseInt(st.nextToken());
                deque.offerFirst(x);
            } else if (s.equals("push_back")) {
                x = Integer.parseInt(st.nextToken());
                deque.offer(x);
            } else if (s.equals("pop_front")) {
                x = deque.peek();

                if (x != null) {
                    sb.append(x).append("\n");
                    deque.poll();
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (s.equals("pop_back")) {
                x = deque.peekLast();

                if (x != null) {
                    sb.append(x).append("\n");
                    deque.pollLast();
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (s.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (s.equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (s.equals("front")) {
                x = deque.peek();

                if (x != null) {
                    sb.append(x).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (s.equals("back")) {
                x = deque.peekLast();

                if (x != null) {
                    sb.append(x).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
