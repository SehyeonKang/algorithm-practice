package inflearn.chap8;

import java.util.Scanner;

public class No_10 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] board = new int[7][7];
    static int answer = 0;

    public void dfs(int x, int y) {
        if (x == 6 && y == 6) {
            answer++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx <= 6 && ny >= 0 && ny <= 6 && board[nx][ny] == 0) {
                board[nx][ny] = 1;
                dfs(nx, ny);
                board[nx][ny] = 0;
            }
        }
    }

    public static void main(String[] args) {
        No_10 T = new No_10();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        board[0][0] = 1;
        T.dfs(0, 0);

        System.out.println(answer);
    }
}
