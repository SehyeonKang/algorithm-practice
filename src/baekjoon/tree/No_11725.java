package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_11725 {

    static int N;
    static int[] parentNode;
    static ArrayList<ArrayList<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parentNode = new int[N + 1];
        tree = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }

        bfs();

        for (int i = 2; i <= N; i++) {
            sb.append(parentNode[i]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] checked = new boolean[N + 1];

        q.add(1);
        checked[1] = true;

        while (!q.isEmpty()) {
            int newNode = q.poll();

            for (int node : tree.get(newNode)) {
                if (!checked[node]) {
                    checked[node] = true;
                    q.add(node);
                    parentNode[node] = newNode;
                }
            }
        }
    }
}
