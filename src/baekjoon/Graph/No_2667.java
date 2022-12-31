package baekjoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_2667 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] map;
    static boolean[][] visited;
    static final int[] DR = {1, -1, 0, 0};
    static final int[] DC = {0, 0, 1, -1};
    static int apartNum = 0;
    static int n =0;
    static ArrayList<Integer> apartments = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    apartNum++;
                    apartments.add(0);
                    dfs(i, j);
                }
            }
        }

        Collections.sort(apartments);

        sb.append(apartNum).append("\n");
        for (int i = 0; i < apartNum; i++) {
            sb.append(apartments.get(i)).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;
        apartments.set(apartNum - 1, apartments.get(apartNum - 1) + 1);

        for (int i = 0; i < 4; i++) {
            int nRow = row + DR[i];
            int nCol = col + DC[i];

            if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < n) {
                if (map[nRow][nCol] == 1 && !visited[nRow][nCol]) {
                    dfs(nRow, nCol);
                }
            }
        }


    }
}
