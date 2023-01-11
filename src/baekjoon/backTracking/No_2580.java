package baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2580 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);
    }

    private static void sudoku(int row, int col) {

        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (map[row][col] == 0) {
            for (int i = 1; i < 10; i++) {
                if (possibility(row, col, i)) {
                    map[row][col] = i;
                    sudoku(row, col + 1);
                }
            }

            map[row][col] = 0;
            return;
        }

        sudoku(row, col + 1);
    }

    private static boolean possibility(int row, int col, int value) {

        for (int i = 0; i < 9; i++) {
            if (map[row][i] == value)
                return false;
        }

        for (int i = 0; i < 9; i++) {
            if (map[i][col] == value)
                return false;
        }

        int squareRow = (row / 3) * 3;
        int squareCol = (col / 3) * 3;

        for (int i = squareRow; i < squareRow + 3; i++) {
            for (int j = squareCol; j < squareCol + 3; j++) {
                if (map[i][j] == value)
                    return false;
            }
        }

        return true;
    }
}
