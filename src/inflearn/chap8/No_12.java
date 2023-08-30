package inflearn.chap8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No_12 {

    static int m, n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] box;
    static int answer = -1;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void bfs() {
        int L = 0;
        int count = 0;
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 1)
                    queue.offer(new Point(i, j));

                if (box[i][j] == 0)
                    count++;
            }
        }

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point point = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = point.x + dx[j];
                    int ny = point.y + dy[j];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                        count--;
                    }
                }
            }

            L++;
        }

        if (count == 0)
            answer = L - 1;
    }

    public static void main(String[] args) {
        No_12 T = new No_12();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        box = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = sc.nextInt();
            }
        }

        T.bfs();
        System.out.println(answer);
    }
}
