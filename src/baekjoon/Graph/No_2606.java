package baekjoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {

        int vertex = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

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

        bfs(1);

        int result = 0;
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == 1) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        visited[vertex] = 1;

        while (!queue.isEmpty()) {
            int fromVertex = queue.poll();

            for (int i = 0; i < graph.get(fromVertex).size(); i++) {
                int newVertex = graph.get(fromVertex).get(i);

                if (visited[newVertex] == 1) {
                    continue;
                }

                queue.offer(newVertex);
                visited[newVertex] = 1;
            }
        }
    }
}
