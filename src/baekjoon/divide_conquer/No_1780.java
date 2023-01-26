package baekjoon.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1780 {

    static int[] numArr = new int[3];
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N, N);

        for (int i = 0; i < 3; i++) {
            System.out.println(numArr[i]);
        }
    }

    private static void partition(int startX, int startY, int endX, int endY) {

        if (numCheck(startX, startY, endX, endY))
            return;

        int midX1 = (startX * 2 + endX) / 3;
        int midX2 = (startX + endX * 2) / 3;
        int midY1 = (startY * 2 + endY) / 3;
        int midY2 = (startY + endY * 2) / 3;

        partition(startX, startY, midX1, midY1);
        partition(startX, midY1, midX1, midY2);
        partition(startX, midY2, midX1, endY);
        partition(midX1, startY, midX2, midY1);
        partition(midX1, midY1, midX2, midY2);
        partition(midX1, midY2, midX2, endY);
        partition(midX2, startY, endX, midY1);
        partition(midX2, midY1, endX, midY2);
        partition(midX2, midY2, endX, endY);
    }

    private static boolean numCheck(int startX, int startY, int endX, int endY) {

        int[] check = new int[3];
        int n = endX - startX;

        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                if (map[i][j] == -1) {
                    check[0]++;
                } else if (map[i][j] == 0) {
                    check[1]++;
                } else
                    check[2]++;
            }
        }

        if (check[0] == n * n) {
            numArr[0]++;
            return true;
        } else if (check[1] == n * n) {
            numArr[1]++;
            return true;
        } else if (check[2] == n * n) {
            numArr[2]++;
            return true;
        }

        return false;

    }
}
