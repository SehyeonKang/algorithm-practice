package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_1707 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int K, V, E;
    static boolean bipartiteCheck;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] colors;
    static final int BLACK = 1;
    static final int WHITE = -1;

    public static void main(String[] args) throws IOException {

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            colors = new int[V + 1];
            for (int j = 0; j < V + 1; j++) {
                graph.add(new ArrayList<>());
                colors[i] = 0;
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());

                int fromV = Integer.parseInt(st.nextToken());
                int toV = Integer.parseInt(st.nextToken());

                graph.get(fromV).add(toV);
                graph.get(toV).add(fromV);
            }

            bipartiteCheck = true;
            for (int j = 0; j < V + 1; j++) {

                if (!bipartiteCheck)
                    break;

                if (colors[j] == 0)
                    bfs(j, BLACK);
            }

            if (bipartiteCheck) {
                System.out.println("YES");
            } else
                System.out.println("NO");
        }
    }

    private static void bfs(int startVertex, int color) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(startVertex);
        colors[startVertex] = color;

        while (!q.isEmpty()) {
            int vertex = q.poll();

            for (int i = 0; i < graph.get(vertex).size(); i++) {
                int newVertex = graph.get(vertex).get(i);

                if (colors[newVertex] == 0) {
                    q.offer(newVertex);
                    colors[newVertex] = colors[vertex] * -1;
                } else if (colors[newVertex] == colors[vertex]) {
                    bipartiteCheck = false;
                    return;
                }
            }
        }
    }
}
