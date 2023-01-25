package baekjoon.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2630 {

    static int white = 0;
    static int blue = 0;
    static int[][] square;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        square = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N, N);

        System.out.println(white + "\n" + blue);
    }

    public static void partition(int colStart, int rowStart, int colEnd, int rowEnd) {

        if (colorCheck(colStart, rowStart, colEnd, rowEnd))
            return;


        int colMid = (colStart + colEnd) / 2;
        int rowMid = (rowStart + rowEnd) / 2;

        partition(colStart, rowStart, colMid, rowMid);
        partition(colMid, rowStart, colEnd, rowMid);
        partition(colStart, rowMid, colMid, rowEnd);
        partition(colMid, rowMid, colEnd, rowEnd);
    }

    public static boolean colorCheck(int colStart, int rowStart, int colEnd, int rowEnd) {

        int whiteNum = 0;
        int blueNum = 0;

        for (int i = colStart; i < colEnd; i++) {
            for (int j = rowStart; j < rowEnd; j++) {
                if (square[i][j] == 0) {
                    whiteNum++;
                } else
                    blueNum++;
            }
        }

        if (whiteNum == Math.pow(colEnd - colStart, 2)) {
            white++;
            return true;
        }

        if (blueNum == Math.pow(colEnd - colStart, 2)) {
            blue++;
            return true;
        }

        return false;
    }
}
