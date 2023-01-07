package baekjoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_7569 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int M, N, H;
    static int[][][] box;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[M][N][H];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < M; k++) {
                    box[k][j][i] = Integer.parseInt(st.nextToken());

                    if (box[k][j][i] == 1) {
                        queue.offer(new int[]{k, j, i});
                    }
                }
            }
        }

        int result;
        result = bfs();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < H; k++) {

                    if (box[i][j][k] == 0)
                        result = -1;
                }
            }
        }

        System.out.println(result);
    }

    private static int bfs() {

        int day = 0;
        int x, y, z;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            x = pos[0];
            y = pos[1];
            z = pos[2];

            for (int i = 0; i < 6; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                int newZ = z + dz[i];

                if (newX >= 0 && newY >= 0 && newZ >= 0 && newX < M && newY < N && newZ < H) {
                    if (box[newX][newY][newZ] == 0) {
                        queue.offer(new int[]{newX, newY, newZ});
                        box[newX][newY][newZ] = box[x][y][z] + 1;
                        day = box[x][y][z];
                    }
                }
            }
        }

        return day;
        
    }
}
