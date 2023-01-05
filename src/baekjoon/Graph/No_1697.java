package baekjoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_1697 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[] walk = {-1, 1};
    static int[] road = new int[100001];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int seconds = bfs(N);

        System.out.println(seconds);
    }

    private static int bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        int dest = K;
        road[N] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < 3; i++) {
                int newNode;

                if (i < 2) {
                    newNode = node + walk[i];
                } else
                    newNode = node * 2;

                if (newNode >= 0 && newNode <= 100000) {
                    if (road[newNode] == 0 && newNode != N) {
                        queue.add(newNode);
                        road[newNode] = road[node] + 1;

                        if (newNode == dest)
                            return road[newNode];
                    }
                }
            }
        }

        return 0;
    }
}
