package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_14889 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, gap;
    //static int[] member;
    static boolean[] member;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        member = new boolean[N];
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        gap = Integer.MAX_VALUE;
        dfs(0, 0);

        System.out.println(gap);
    }

    private static void dfs(int index, int depth) {

        if (depth == N / 2) {
            int result = calculate();

            if (result == 0) {
                System.out.println(0);
                System.exit(0);
            }

            if (result < gap)
                gap = result;

            return;
        }

        for (int i = index; i < N; i++) {
            if (!member[i]) {
                member[i] = true;
                dfs(i + 1, depth + 1);
                member[i] = false;
            }
        }
    }

    private static int calculate() {

        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!member[i] && !member[j]) {
                    startTeam = startTeam + map[i][j];
                } else if (member[i] && member[j]) {
                    linkTeam = linkTeam + map[i][j];
                }
            }
        }

        return Math.abs(startTeam - linkTeam);
    }
}
