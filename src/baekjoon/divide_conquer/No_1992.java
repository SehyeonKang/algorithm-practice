package baekjoon.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1992 {

    static StringBuilder sb = new StringBuilder();

    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        partition(0, N, 0, N);

        System.out.println(sb);
    }

    private static void partition(int startRow, int endRow, int startCol, int endCol) {

        if (colorCheck(startRow, endRow, startCol, endCol))
            return;

        int midRow = (startRow + endRow) / 2;
        int midCol = (startCol + endCol) / 2;

        sb.append("(");

        partition(startRow, midRow, startCol, midCol);
        partition(startRow, midRow, midCol, endCol);
        partition(midRow, endRow, startCol, midCol);
        partition(midRow, endRow, midCol, endCol);

        sb.append(")");
    }

    private static boolean colorCheck(int startRow, int endRow, int startCol, int endCol) {

        int white = 0;
        int black = 0;
        int n = endCol - startCol;

        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (map[i][j] == 0) {
                    white++;
                } else
                    black++;
            }
        }

        if (white == n * n) {
            sb.append("0");
            return true;
        }

        if (black == n * n) {
            sb.append("1");
            return true;
        }

        return false;
    }
}
