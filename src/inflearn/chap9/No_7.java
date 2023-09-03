package inflearn.chap9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 크루스칼 알고리즘
 */
public class No_7 {

    static int[] unf;
    static ArrayList<Edge> array = new ArrayList<>();

    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public int find(int v) {
        if (unf[v] != v)
            unf[v] = find(unf[v]);

        return unf[v];
    }

    public void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb)
            unf[fa] = fb;
    }

    public int solution(int n) {
        int answer = 0;
        int cnt = 0;
        Collections.sort(array);

        for (Edge e : array) {
            if (cnt == n - 1)
                break;

            int fa = find(e.v1);
            int fb = find(e.v2);
            if (fa != fb) {
                answer += e.cost;
                union(e.v1, e.v2);
                cnt++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        No_7 T = new No_7();
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        unf = new int[v + 1];

        for (int i = 0; i < v; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            array.add(new Edge(v1, v2, cost));
        }
        System.out.println(T.solution(v));
    }
}
