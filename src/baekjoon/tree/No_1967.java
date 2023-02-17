package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No_1967 {

    static int n;
    static int max = 0;
    static ArrayList<Node> tree[];
    static boolean visited[];

    private static class Node {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, 0);
        }

        System.out.println(max);
    }

    private static void dfs(int num, int weight) {

        for (Node n : tree[num]) {
            if (!visited[n.num]) {
                visited[n.num] = true;
                dfs(n.num, weight + n.weight);
            }
        }

        max = (max < weight) ? weight : max;
    }
}
