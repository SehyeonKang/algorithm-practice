package inflearn.chap9;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 프림 알고리즘
 */
public class No_8 {

    static int[] check;

    static ArrayList<ArrayList<Edge>> array = new ArrayList<>();

    static class Edge implements Comparable<Edge> {
        int vex;
        int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public int solution() {
        int answer = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (check[e.vex] == 0) {
                check[e.vex] = 1;
                answer += e.cost;

                for (Edge ob : array.get(e.vex)) {
                    if (check[ob.vex] == 0) {
                        pq.offer(new Edge(ob.vex, ob.cost));
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        No_8 T = new No_8();
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        check = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            array.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();

            array.get(v1).add(new Edge(v2, cost));
            array.get(v2).add(new Edge(v1, cost));
        }

        System.out.println(T.solution());
    }
}
