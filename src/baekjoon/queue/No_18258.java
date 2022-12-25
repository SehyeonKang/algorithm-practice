package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int lastNum = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (s.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
                lastNum = num;
            } else if (s.equals("pop")) {
                Integer num = queue.poll();

                if (num == null) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(num).append("\n");
                }
            } else if (s.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (s.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (s.equals("front")) {
                Integer num = queue.peek();

                if (num == null) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(num).append("\n");
                }
            } else if (s.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(lastNum).append("\n");
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
