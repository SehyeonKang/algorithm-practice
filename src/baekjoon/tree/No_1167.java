package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No_1167 {

    static int max = 0;
    static int maxNum = 0;
    static ArrayList<Node> tree[];
    static boolean visited[];

    private static class Node {
        int num, weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V + 1];

        for (int i = 0; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            while (end != -1) {
                int weight = Integer.parseInt(st.nextToken());
                tree[start].add(new Node(end, weight));
                end = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        dfs(maxNum, 0);

        System.out.println(max);
    }

    private static void dfs(int num, int weight) {

        visited[num] = true;

        for (Node n : tree[num]) {
            if (!visited[n.num]) {
                visited[n.num] = true;
                dfs(n.num, n.weight + weight);
            }
        }

        if (max < weight) {
            max = weight;
            maxNum = num;
        }
    }
}
