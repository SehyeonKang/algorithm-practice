package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();
        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int cnt = 1;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            int max = queue.stream().max(Integer::compare).orElse(-1);
            while (true) {

                int peek = queue.peek();
                if (peek == max) {
                    if (m == 0) {
                        sb.append(cnt).append("\n");
                        break;
                    } else {
                        queue.poll();
                        max = queue.stream().max(Integer::compare).orElse(-1);
                        m--;
                        cnt++;
                    }
                } else {
                    queue.add(queue.poll());
                    if (m == 0) {
                        m = queue.size() - 1;
                    } else {
                        m--;
                    }
                }
            }

            queue.clear();
            cnt = 1;
        }

        System.out.println(sb);

    }
}
