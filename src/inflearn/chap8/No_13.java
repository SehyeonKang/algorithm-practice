package inflearn.chap8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No_13 {

    static int n;
    static int answer = 0;
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};
    static int[][] map, check;
    static Queue<Point> queue = new LinkedList<>();
    static Queue<Point> island = new LinkedList<>();
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void bfs() {
        int queueLength = queue.size();

        for (int i = 0; i < queueLength; i++) {
            Point p = queue.poll();

            if (check[p.x][p.y] == 0) {
                check[p.x][p.y] = 1;
                island.offer(new Point(p.x, p.y));

                while (!island.isEmpty()) {
                    int islandLength = island.size();

                    for (int j = 0; j < islandLength; j++) {
                        Point iP = island.poll();

                        for (int k = 0; k < 8; k++) {
                            int nx = iP.x + dx[k];
                            int ny = iP.y + dy[k];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < n
                                    && map[nx][ny] == 1 && check[nx][ny] == 0) {
                                check[nx][ny] = 1;
                                island.offer(new Point(nx, ny));
                            }
                        }
                    }
                }

                answer++;
            }
        }

    }

    public static void main(String[] args) {
        No_13 T = new No_13();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        check = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1)
                    queue.offer(new Point(i, j));
            }
        }
        T.bfs();
        System.out.println(answer);
    }
}
