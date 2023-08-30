package inflearn.chap8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No_11 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] board = new int[7][7];
    static int answer = -1;

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void bfs(int x, int y) {
        int L = 0;
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(x, y));
        board[x][y] = 1;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Pos pos = queue.poll();

                if (pos.x == 6 && pos.y == 6) {
                    answer = L;
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = pos.x + dx[j];
                    int ny = pos.y + dy[j];

                    if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        queue.offer(new Pos(nx, ny));
                    }
                }
            }

            L++;
        }
    }

    public static void main(String[] args) {
        No_11 T = new No_11();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        T.bfs(0, 0);

        System.out.println(answer);
    }
}
