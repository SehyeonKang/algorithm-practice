package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] dfsVisited;
    static int[] bfsVisited;
    static int[] dfsVisitedCount;
    static int[] bfsVisitedCount;
    static int dfsCount;
    static int bfsCount;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        for (int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList<>());
        }
        dfsVisited = new int[vertex + 1];
        bfsVisited = new int[vertex + 1];
        dfsVisitedCount = new int[vertex + 1];
        bfsVisitedCount = new int[vertex + 1];

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());

            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());

            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }

        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        dfsCount = 0;
        dfs(startVertex);
        bfs(startVertex);

        for (int i = 0; i < dfsCount + 1; i++) {
            sb.append(dfsVisitedCount[i]).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < bfsCount; i++) {
            sb.append(bfsVisitedCount[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static void dfs(int vertex) {
        dfsVisited[vertex] = 1;
        dfsVisitedCount[dfsCount] = vertex;

        for (int i = 0; i < graph.get(vertex).size(); i++) {
            int newVertex = graph.get(vertex).get(i);

            if (dfsVisited[newVertex] == 0) {
                dfsCount++;
                dfs(newVertex);
            }
        }
    }

    private static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        bfsCount = 0;
        queue.offer(vertex);
        bfsVisited[vertex] = 1;
        bfsVisitedCount[bfsCount++] = vertex;

        while (!queue.isEmpty()) {
            int fromVertex = queue.poll();

            for (int i = 0; i < graph.get(fromVertex).size(); i++) {
                int newVertex = graph.get(fromVertex).get(i);

                if (bfsVisited[newVertex] == 1) {
                    continue;
                }

                queue.offer(newVertex);
                bfsVisited[newVertex] = 1;
                bfsVisitedCount[bfsCount++] = newVertex;
            }
        }
    }
}
