package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_2178 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(c[j]);
            }
        }

        bfs(0, 0);

        System.out.println(map[N - 1][M - 1]);

    }

    public static void bfs(int x, int y) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Integer[] arr = queue.poll();
            x = arr[0];
            y = arr[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
                    if (!visited[newX][newY] && map[newX][newY] != 0) {
                        visited[newX][newY] = true;
                        queue.offer(new Integer[]{newX, newY});
                        map[newX][newY] = map[x][y] + 1;
                    }
                }
            }
        }
    }
}
