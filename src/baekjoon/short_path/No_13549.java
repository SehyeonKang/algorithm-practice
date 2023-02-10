package baekjoon.short_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 다익스트라 알고리즘
 */
public class No_13549 {

    private static class Node implements Comparable<Node> {

        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static final int INF = 100000;
    static int V = 100000;
    static int N, K;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        dijkstra(N);

        System.out.println(dist[K]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (curNode.weight > dist[curNode.end])
                continue;

            if (curNode.weight > dist[K])
                continue;

            if (curNode.end + 1 <= V && dist[curNode.end + 1] > curNode.weight + 1) {
                dist[curNode.end + 1] = curNode.weight + 1;
                pq.add(new Node(curNode.end + 1, curNode.weight + 1));
            }

            if (curNode.end - 1 >= 0 && dist[curNode.end - 1] > curNode.weight + 1) {
                dist[curNode.end - 1] = curNode.weight + 1;
                pq.add(new Node(curNode.end - 1, curNode.weight + 1));
            }

            if (curNode.end * 2 <= 100000 && dist[curNode.end * 2] > curNode.weight) {
                dist[curNode.end * 2] = curNode.weight;
                pq.add(new Node(curNode.end * 2, curNode.weight));
            }
        }
    }
}