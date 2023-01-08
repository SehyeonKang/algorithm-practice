package baekjoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_2206 {

    static class Place {
        int n;
        int m;
        int dis;
        int breakCount;

        public Place(int n, int m, int dis, int breakCount) {
            this.n = n;
            this.m = m;
            this.dis = dis;
            this.breakCount = breakCount;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, result;
    static int[][] map, visit;
    static int[] dn = {1, -1, 0, 0};
    static int[] dm = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] cArr = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(cArr[j]);
                visit[i][j] = Integer.MAX_VALUE;
            }
        }

        result = Integer.MAX_VALUE;

        bfs(0, 0);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else
            System.out.println(result);

    }

    private static void bfs(int n, int m) {

        Queue<Place> queue = new LinkedList<>();

        queue.offer(new Place(n, m, 1, 0));
        visit[n][m] = 0;

        while (!queue.isEmpty()) {

            Place place = queue.poll();

            if (place.n == N - 1 && place.m == M - 1) {
                result = place.dis;
                break;
            }
            System.out.println(place.n + ", " + place.m);

            for (int i = 0; i < 4; i++) {
                int newN = place.n + dn[i];
                int newM = place.m + dm[i];

                if (newN < 0 || newM < 0 || newN >= N || newM >= M)
                    continue;

                if (visit[newN][newM] <= place.breakCount)
                    continue;

                if (map[newN][newM] == 0) {
                    visit[newN][newM] = place.breakCount;
                    queue.offer(new Place(newN, newM, place.dis + 1, place.breakCount));
                } else {
                    if (place.breakCount == 0) {
                        visit[newN][newM] = place.breakCount + 1;
                        queue.offer(new Place(newN, newM, place.dis + 1, place.breakCount + 1));
                    }
                }
            }
        }
    }
}
