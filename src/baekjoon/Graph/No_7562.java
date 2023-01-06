package baekjoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_7562 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int I;
    static int[][] map;
    static int[] start = new int[2];
    static int[] dest = new int[2];
    static int[] dx = {-2, 2, -1, 1};
    static int[] dy = {-1, 1, -2, 2};

    public static void main(String[] args) throws IOException {

        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            I = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            dest[0] = Integer.parseInt(st.nextToken());
            dest[1] = Integer.parseInt(st.nextToken());

            map = new int[I][I];

            int result;
            if (start[0] == dest[0] && start[1] == dest[1]) {
                result = 0;
            } else
                result = bfs(start[0], start[1]);

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        map[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int startX = pos[0];
            int startY = pos[1];

            for (int i = 0; i < 8; i++) {
                int newX = startX + dx[i / 2];
                int newY;
                if (i < 4) {
                    newY = startY + dy[i % 2];
                } else
                    newY = startY + dy[i % 2 + 2];

                if (newX >= 0 && newY >= 0 && newX < I && newY < I) {
                    if (map[newX][newY] == 0 && newX != startX && newY != startY) {
                        map[newX][newY] = map[startX][startY] + 1;
                        queue.offer(new int[] {newX, newY});
                    }

                    if (newX == dest[0] && newY == dest[1])
                        return map[newX][newY];
                }
            }
        }

        return 0;
    }
}
