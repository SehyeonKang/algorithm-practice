package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_24445 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        for (int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new int[vertex + 1];

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());

            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());

            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }

        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
            Collections.reverse(graph.get(i));
        }

        bfs(startVertex);

        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int vertex) {
        int count = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        visited[vertex] = count++;

        while (!queue.isEmpty()) {
            int fromVertex = queue.poll();

            for (int i = 0; i < graph.get(fromVertex).size(); i++) {
                int newVertex = graph.get(fromVertex).get(i);

                if (visited[newVertex] != 0) {
                    continue;
                }

                queue.offer(newVertex);
                visited[newVertex] = count++;
            }
        }
    }
}
