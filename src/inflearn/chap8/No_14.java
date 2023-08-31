package inflearn.chap8;

import java.util.ArrayList;
import java.util.Scanner;

public class No_14 {
    static int n, m;
    static int count = 0;
    static int answer = Integer.MAX_VALUE;
    static int[][] map, check;
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

    public void calculate() {
        int sum = 0;

        for (Point h : home) {
            int dis = Integer.MAX_VALUE;

            for (Point p : pizza) {
                if (check[p.x][p.y] == 1)
                    dis = Math.min(dis, Math.abs(h.x - p.x) + Math.abs(h.y - p.y));
            }
            sum += dis;
        }
        answer = Math.min(answer, sum);
    }

    public void dfs(int L) {
        if (count == m) {
            calculate();
            return;
        }

        if (L == pizza.size()) {
            if (count == m)
                calculate();

            return;
        }

        if (L - count > pizza.size() - m)
            return;

        Point point = pizza.get(L);

        check[point.x][point.y] = 1;
        count++;
        dfs(L + 1);
        check[point.x][point.y] = 0;
        count--;
        dfs(L + 1);
    }

    public static void main(String[] args) {
        No_14 T = new No_14();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        check = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 1)
                    home.add(new Point(i, j));

                if (map[i][j] == 2)
                    pizza.add(new Point(i, j));

            }
        }

        T.dfs(0);

        System.out.println(answer);
    }
}
