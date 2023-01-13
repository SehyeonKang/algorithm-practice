package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_16928 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static ArrayList<Integer[]> map = new ArrayList<>();
    static int[] dice = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 100; i++) {
            map.add(new Integer[]{0, -1});
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map.set(x - 1, new Integer[]{0, y - 1});
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map.set(u - 1, new Integer[]{0, v - 1});
        }

        bfs();

        System.out.println(map.get(99)[0]);

    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int pos = queue.poll();

            for (int i = 0; i < 6; i++) {
                int newPos = pos + dice[i];

                if (newPos < 100) {
                    int check = map.get(newPos)[1];

                    if (check != -1)
                        newPos = map.get(newPos)[1];

                    if (newPos > 0 && map.get(newPos)[0] == 0) {
                        queue.offer(newPos);
                        map.set(newPos, new Integer[]{map.get(pos)[0] + 1, map.get(newPos)[1]});
                    }

                    if (newPos == 99)
                        return;
                }
            }
        }
    }
}
