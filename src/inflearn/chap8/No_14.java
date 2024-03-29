package inflearn.chap8;

import java.util.ArrayList;
import java.util.Scanner;

public class No_14 {
    static int n, m;
    static int count = 0;
    static int answer = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> home = new ArrayList<>();
    static ArrayList<Point> pizza = new ArrayList<>();

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void dfs(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (Point h : home) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x - pizza.get(i).x) + Math.abs(h.y - pizza.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < pizza.size(); i++) {
                combi[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        No_14 T = new No_14();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = sc.nextInt();

                if (tmp == 1)
                    home.add(new Point(i, j));

                if (tmp == 2)
                    pizza.add(new Point(i, j));

            }
        }

        T.dfs(0, 0);

        System.out.println(answer);
    }
}
