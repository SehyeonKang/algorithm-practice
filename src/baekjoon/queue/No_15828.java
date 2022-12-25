package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_15828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int bufferSize = Integer.parseInt(br.readLine());
        int cnt = 0;
        int n = Integer.parseInt(br.readLine());

        while (n != -1) {

            if (n == 0) {
                queue.poll();
                cnt--;
            } else {

                if (cnt != bufferSize) {
                    queue.add(n);
                    cnt++;
                }
            }

            n = Integer.parseInt(br.readLine());
        }

        if (queue.isEmpty()) {
            System.out.println("empty");
        } else {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                sb.append(queue.poll()).append(" ");
            }
        }

        System.out.println(sb);
    }
}
