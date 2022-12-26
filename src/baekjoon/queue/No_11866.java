package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        sb.append("<");
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                int num = queue.poll();
                queue.add(num);
            }

            if (queue.size() == 1) {
                sb.append(queue.poll()).append(">");
            } else {
                sb.append(queue.poll()).append(", ");
            }
        }

        System.out.println(sb);
    }
}
