package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        int check = 0;

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (true) {
            if (check == 0) {

                if (queue.size() == 1) {
                    System.out.println(queue.peek());
                    break;
                } else {
                    queue.poll();
                    check = 1;
                }
            } else {
                int num = queue.poll();
                queue.add(num);
                check = 0;
            }
        }
    }
}
